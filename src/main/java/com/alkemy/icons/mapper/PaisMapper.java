package com.alkemy.icons.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;

@Component
public class PaisMapper {

	/*
	 * Recibe <dto> y lo convierte a <entity>
	 */
	public PaisEntity paisDTO2Entity(PaisDTO dto) {
		PaisEntity entity = new PaisEntity();
		// Seteamos los valores del dto al entity
		entity.setImagen(dto.getImagen());
		entity.setDenominacion(dto.getDenominacion());
		entity.setCantidadHabitantes(dto.getCantidadHabitantes());
		entity.setSuperficie(dto.getSuperficie());
		entity.setContinenteId(dto.getContinenteId());
//		entity.setIcons(dto.getIcons());
		
		return entity;
	}
	
	/*
	 * Recibe un <entity> y lo convierte a <dto>
	 */
	public PaisDTO paisEntity2DTO(PaisEntity entity) {
		PaisDTO dto = new PaisDTO();
		// Seteamos los valores deñ entity al dto
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		dto.setCantidadHabitantes(entity.getCantidadHabitantes());
		dto.setSuperficie(entity.getSuperficie());
		dto.setContinenteId(entity.getContinenteId());
//		dto.setIcons(entity.getIcons());
		
		return dto;
	}
	
	/*
	 * Recibe una lista de entities y la convierte a lista dto
	 */
	public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities) {
		List<PaisDTO> dtos = new ArrayList<>(); // instanciamos la lista dto
		
		// Recorremos la lista <entities>
		for (PaisEntity entity : entities) {
			dtos.add(this.paisEntity2DTO(entity)); // convertimos c/u de las entidades a dto y las almacenamos en la lista dto
		}
		
		return dtos;
	}
	
}
