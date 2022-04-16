package com.project.estoque.dto;

import java.io.Serializable;

public class PrecoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double preco;
	
	public PrecoDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 
	
	

}
