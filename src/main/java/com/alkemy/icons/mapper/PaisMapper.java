package com.alkemy.icons.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;

@Component
public class PaisMapper {

	@Autowired
	private IconMapper iconMapper;
	
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
	public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
		PaisDTO dto = new PaisDTO();
		// Seteamos los valores deñ entity al dto
		dto.setId(entity.getId());
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		dto.setCantidadHabitantes(entity.getCantidadHabitantes());
		dto.setSuperficie(entity.getSuperficie());
		dto.setContinenteId(entity.getContinenteId());
		
		// Validamos si tenemos que cargar los iconos o no
		if (loadIcons) {
			List<IconDTO> iconsDTO = this.iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
			dto.setIcons(iconsDTO);
		}
		return dto;
	}
	
	/*
	 * Recibe una lista de entities y la convierte a lista dto
	 */
	public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
		
		List<PaisDTO> dtos = new ArrayList<>(); // instanciamos la lista dto
		
		// Recorremos la lista <entities>
		for (PaisEntity entity : entities) {
			dtos.add(this.paisEntity2DTO(entity, loadIcons)); // convertimos c/u de las entidades a dto y las almacenamos en la lista dto
		}
		
		return dtos;
	}

	/*
	 * convierte una lista de paisDTO a una lista paisEntity
	 */
	public List<PaisEntity> paisDTOList2EntityList(List<PaisDTO> dtoList) {
		
		List<PaisEntity> entityList = new ArrayList<>();
		
		for (PaisDTO dto : dtoList) {
			entityList.add(this.paisDTO2Entity(dto));
		}
		
		return entityList;
	}
	
}
