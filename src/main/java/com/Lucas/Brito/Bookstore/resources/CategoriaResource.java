package com.Lucas.Brito.Bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Lucas.Brito.Bookstore.domain.Categoria;
import com.Lucas.Brito.Bookstore.dtos.CategoriasDTO;
import com.Lucas.Brito.Bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<List<CategoriasDTO>> findAll() {
		List<Categoria> list =service.findAll();
		List<CategoriasDTO> listDTO = list.stream().map(obj -> new CategoriasDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
}