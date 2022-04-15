package com.project.estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.estoque.dto.PrecoDto;

@RestController
@RequestMapping("/api/v1/preco/")
public class PrecoController {

	@PutMapping
	private ResponseEntity<PrecoDto> alteraEstoque(@RequestBody PrecoDto precoDto) {
		return new ResponseEntity<PrecoDto>(HttpStatus.OK);
	}
	
	
}
