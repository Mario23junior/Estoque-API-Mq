package com.project.estoque.dto;

import java.io.Serializable;

public class EstoqueDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double quantidade;
	
	public EstoqueDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
