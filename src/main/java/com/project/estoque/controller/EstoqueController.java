package com.project.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estoque.constant.RabbitmqConstantes;
import com.project.estoque.dto.EstoqueDto;
import com.project.estoque.service.RabbitmqService;

@RestController
@RequestMapping("/api/v1/estoque/")
public class EstoqueController {
	
	@Autowired
	RabbitmqService service;
	
	@PutMapping
	private ResponseEntity<EstoqueDto> alteraEstoque(@RequestBody EstoqueDto  estoqueDto) {
		this.service.sendMensage(RabbitmqConstantes.FILA_ESTOQUE, estoqueDto);
		System.out.println(estoqueDto.getQuantidade());
		return new ResponseEntity<EstoqueDto>(HttpStatus.OK);
	}
	
	
}
