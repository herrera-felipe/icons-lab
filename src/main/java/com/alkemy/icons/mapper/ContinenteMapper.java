package com.alkemy.icons.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alkemy.icons.dto.ContinenteDTO;
import com.alkemy.icons.entity.ContinenteEntity;

@Component
public class ContinenteMapper {
	
	/*
	 * Recibe un DTO del controller y lo convierte a entity
	 */
	public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
		ContinenteEntity entity = new ContinenteEntity(); // instanciamos una entidad
		// Seteamos los valores que trae el dto a la entidad
		entity.setImagen(dto.getImagen());
		entity.setDenominacion(dto.getDenominacion());
		return entity;
	}
	
	/*
	 * Recibe un Entity y lo convierte a DTO
	 */
	public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
		ContinenteDTO dto = new ContinenteDTO(); // instanciamos un dto
		// seteamos los valores que trae la entidad al dto
		dto.setId(entity.getId()); // Aqui asignamos el id ya que ha sido generado al persistir la entidad
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		return dto;
	}

	/*
	 * Recibe una lista de entidades y la convierte en una lista DTO
	 */
	public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities) {
		List<ContinenteDTO> dtos = new ArrayList<>(); // Instanciamos la lista dto
		
		// Recorremos la lista que llega por parametro
		for (ContinenteEntity entity : entities) {
			dtos.add(this.continenteEntity2DTO(entity)); // convertimos los entity a dto y se agregan a la lista dto
		}
		return dtos;
	}

}
