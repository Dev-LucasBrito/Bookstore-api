package com.Lucas.Brito.Bookstore.dtos;

import java.io.Serializable;

import com.Lucas.Brito.Bookstore.domain.Categoria;

public class CategoriasDTO implements Serializable {

	private static final long serialVersionUID = -5167910164072056100L;
	private Integer id;
	private String nome;
	private String descricao;

	public CategoriasDTO() {
		super();
	}

	public CategoriasDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
