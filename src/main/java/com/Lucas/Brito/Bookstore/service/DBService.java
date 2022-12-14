package com.Lucas.Brito.Bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lucas.Brito.Bookstore.domain.Categoria;
import com.Lucas.Brito.Bookstore.domain.Livro;
import com.Lucas.Brito.Bookstore.repositories.CategoriaRepository;
import com.Lucas.Brito.Bookstore.repositories.LivroRepository;

@Service

public class DBService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
  
    public void instanciaBasedeDados() {
        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biogrtafias");
        
        Livro l1 = new Livro(null, "Código Limpo", "Robert Cecil Martin","Lorem ipsum" , cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstern","Lorem ipsum" , cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H.G. Welss","Lorem ipsum" , cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells","Lorem ipsum" , cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov","Lorem ipsum" , cat2);
        
        
        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
        
        
        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
        
    }
    
}