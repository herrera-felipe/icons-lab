package com.alkemy.icons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.icons.dto.ContinenteDTO;
import com.alkemy.icons.service.ContinenteService;

@RestController
@RequestMapping("continentes") // Url /continentes
public class ContinenteController {
	
	@Autowired
	private ContinenteService continenteService;
	
	
	@GetMapping
	public ResponseEntity<List<ContinenteDTO>> getall(){
		List<ContinenteDTO> continentes = this.continenteService.getAllContinentes();
		return ResponseEntity.ok().body(continentes); 
	}
	
	/*
	 * Endpoint para poder guardar continentes
	 * con @RequestBody accedemos al body y definimos el tipo de variable DTO
	 * metodo de tipo ResponseEntity porque  vamos a devolver el continente guardado y codigo de estado Http
	 */
	@PostMapping
	public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
		ContinenteDTO continenteGuardado = continenteService.save(continente);
		return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado); // respondemos un 201, y el body con el continente creado
	}
	
}
