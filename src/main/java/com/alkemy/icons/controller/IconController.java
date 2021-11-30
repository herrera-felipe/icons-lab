package com.alkemy.icons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.service.IconService;

@RestController
@RequestMapping("icons")
public class IconController {

	@Autowired
	private IconService iconService;
	
	
//	@GetMapping("/all")
//	public ResponseEntity<List<IconBasicDTO>> getAll() {
//		List<IconBasicDTO> icons = this.iconService.getAllIcons();
//		return ResponseEntity.ok(icons);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<IconDTO> getDetailsById(@PathVariable Long id) {
		IconDTO icon = this.iconService.getDetailsById(id);
		return ResponseEntity.ok(icon);
	}
	
	@PostMapping
	public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
		IconDTO result = this.iconService.save(icon);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon) {
		IconDTO result = this.iconService.update(id, icon);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.iconService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PostMapping("/{id}/pais/{idPais")
	public ResponseEntity<Void> addPais(@PathVariable Long id, @PathVariable Long idPais) {
		this.iconService.addPais(id, idPais);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@DeleteMapping("/{id}/pais/{idPais")
	public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais) {
		this.iconService.removePais(id, idPais);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
