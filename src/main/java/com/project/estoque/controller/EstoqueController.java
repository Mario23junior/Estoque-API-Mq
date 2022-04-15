package com.project.estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estoque.dto.EstoqueDto;

@RestController
@RequestMapping("/api/v1/estoque/")
public class EstoqueController {

	@PutMapping
	private ResponseEntity<EstoqueDto> alteraEstoque(@RequestBody EstoqueDto  estoqueDto) {
		return new ResponseEntity<EstoqueDto>(HttpStatus.OK);
	}
	
	
}
