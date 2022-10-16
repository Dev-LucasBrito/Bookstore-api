package com.Lucas.Brito.Bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.Brito.Bookstore.domain.Livro;
import com.Lucas.Brito.Bookstore.exceptions.ObjectNotFoundException;
import com.Lucas.Brito.Bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + " ,Tipo: " + Livro.class.getName()));	
	}

}
