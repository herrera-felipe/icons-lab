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

import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.service.PaisService;

@RestController
@RequestMapping("paises")
public class PaisController {
	
	@Autowired
	private PaisService paisService;
	
	/*
	 * Endpoint para listar los paises
	 */
	@GetMapping
	public ResponseEntity<List<PaisDTO>> getall() {
		List<PaisDTO> paises = this.paisService.getAllPaises();
		return ResponseEntity.ok().body(paises);
	}
	
	/*
	 * Endpoint para guardar paises
	 */
	@PostMapping
	public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais){
		PaisDTO paisSaved = paisService.save(pais);
		return ResponseEntity.status(HttpStatus.CREATED).body(paisSaved);
	}

}
