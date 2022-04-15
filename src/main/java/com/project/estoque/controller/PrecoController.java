package com.project.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estoque.constant.RabbitmqConstantes;
import com.project.estoque.dto.PrecoDto;
import com.project.estoque.service.RabbitmqService;

@RestController
@RequestMapping("/api/v1/preco/")
public class PrecoController {
	
	@Autowired
	RabbitmqService service;

	@PutMapping
	private ResponseEntity<PrecoDto> alteraEstoque(@RequestBody PrecoDto precoDto) {
		this.service.sendMensage(RabbitmqConstantes.FILA_PREÇO, precoDto);
		return new ResponseEntity<PrecoDto>(HttpStatus.OK);
	}
	
	
}
