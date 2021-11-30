package com.alkemy.icons.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.IconEntity;

@Component
public class IconMapper {

	@Autowired
	private PaisMapper paisMapper;

	public IconEntity iconDTO2Entity(IconDTO dto) {

		IconEntity entity = new IconEntity(); // Intanciamos la entidad
		// Seteamos los valores del dto al entity
		entity.setImagen(dto.getImagen());
		entity.setDenominacion(dto.getDenominacion());
		// Usamos el metodo formateador para setear la fecha correctamente
		entity.setFechaCreacion(this.string2LocalDate(dto.getFechaCreacion()));
		entity.setAltura(dto.getAltura());
		entity.setHistoria(dto.getHistoria());
		entity.setPaises(paisMapper.paisDTOList2EntityList(dto.getPaises()));

		return entity;
	}


	public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {

		IconDTO dto = new IconDTO();
		// Seteamos los valores del entity al dto
		dto.setId(entity.getId()); // Seteamos el id que ya fue creado al persistir
		dto.setImagen(entity.getImagen());
		dto.setDenominacion(entity.getDenominacion());
		dto.setFechaCreacion(entity.getFechaCreacion().toString());
		dto.setAltura(entity.getAltura());
		dto.setHistoria(entity.getHistoria());
		
		// Validamos si se deben cargar o no los paises
		if (loadPaises) {
			List<PaisDTO> paisesDTO = this.paisMapper.paisEntityList2DTOList(entity.getPaises(), false); // Pasamos false para que no se cargen los iconos
			dto.setPaises(paisesDTO);
		}

		return dto;
	}

	
	/*
	 * formatea la fecha que viene en un string a LocalDate
	 */
	private LocalDate string2LocalDate(String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
	}
	
	/*
	 * Actualizacion de datos de un dto a la entidad
	 */
	public void iconEntityUpdate(IconEntity entity, IconDTO dto) {
		entity.setImagen(dto.getImagen());
		entity.setDenominacion(dto.getDenominacion());
		entity.setFechaCreacion(this.string2LocalDate(dto.getFechaCreacion()));
		entity.setAltura(dto.getAltura());
		entity.setHistoria(dto.getHistoria());
	}
	
	/*
	 * Convierte una lista IconEntity a una lista IconDTO
	 */
	public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entityList, boolean loadPaises) {

		List<IconDTO> dtoList = new ArrayList<>();

		for (IconEntity entity : entityList) {
			dtoList.add(this.iconEntity2DTO(entity, loadPaises));
		}

		return dtoList;
	}

	/*
	 * Convierte una lista IconDTO,  a una lista IconEntity
	 */
	public List<IconEntity> iconDTOList2EntityList(List<IconDTO> dtoList) {

		List<IconEntity> entityList = new ArrayList<>();

		for (IconDTO dto : dtoList) {
			entityList.add(this.iconDTO2Entity(dto));
		}

		return entityList;
	}
	
	/*
	 * Recibe una iconEntityList y crea una BasicIconList
	 * Seteando solo los atributos necesarios de nuestro IconBasicDTO
	 */
	public List<IconBasicDTO> iconEntityList2BasicDTOList(List<IconEntity> entities) {
		List<IconBasicDTO> basicDTOList = new ArrayList<>(); // instanciamos la lista dto
		IconBasicDTO basicDTO; 
		
		// Recorremos la entityList
		for (IconEntity entity : entities) {
			basicDTO = new IconBasicDTO(); //Instanciamos el basicDTO
			// seteamos  los valores de la entidad
			basicDTO.setId(entity.getId());
			basicDTO.setImagen(entity.getImagen());
			basicDTO.setDenominacion(entity.getDenominacion());
			basicDTOList.add(basicDTO);
		}
		
		return basicDTOList;
	}

}
