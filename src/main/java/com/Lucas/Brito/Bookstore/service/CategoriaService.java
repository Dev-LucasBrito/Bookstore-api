package com.Lucas.Brito.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.Brito.Bookstore.domain.Categoria;
import com.Lucas.Brito.Bookstore.dtos.CategoriasDTO;
import com.Lucas.Brito.Bookstore.exceptions.ObjectNotFoundException;
import com.Lucas.Brito.Bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ",Tipo: " + Categoria.class.getName()));

	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria create (Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriasDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	
	}

	public void delete(Integer id) {
	findById(id);
	repository.deleteById(id);
	}
}