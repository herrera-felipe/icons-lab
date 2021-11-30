package com.alkemy.icons.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.dto.IconBasicDTO;
import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.entity.IconEntity;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.mapper.IconMapper;
import com.alkemy.icons.repository.IconRepository;
import com.alkemy.icons.service.IconService;
import com.alkemy.icons.service.PaisService;

@Service
public class IconServiceImpl implements IconService {
	
	@Autowired
	private IconRepository iconRepository;

	@Autowired IconMapper iconMapper;
	
	@Autowired
	private PaisService paisService;

	
	public IconDTO save(IconDTO dto) {
		IconEntity entity = this.iconMapper.iconDTO2Entity(dto); // convertir el dto a entidad
		IconEntity entitySaved = this.iconRepository.save(entity); // Peristir a la bd con el repository
		IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false); // convertir el entity a dto para retornar 
		return result;
	}

	
	/*
	 * Retorna una lista basica de iconos, sin cargar los paises
	 */
	public List<IconBasicDTO> getAllIcons() {
		List<IconEntity> entities = this.iconRepository.findAll(); // consulta a la bd
		List<IconBasicDTO> iconBasicDTOs = this.iconMapper.iconEntityList2BasicDTOList(entities); // convertir lista a basicDto
		return iconBasicDTOs;
	}
	

	public IconDTO getDetailsById(Long id) {
		Optional<IconEntity> entity = this.iconRepository.findById(id); // Buscamos la entidad que corresponde al id
		// sino se encuentra el icon lanzamos un ParamNotFound
		if (!entity.isPresent()) {
//			throw new ParamNotFound("Id icono no valido");
		}
		
		IconDTO iconDTO = this.iconMapper.iconEntity2DTO(entity.get(), true);
		return iconDTO;
	}

	/*
	 * MODIFICAR ICON
	 */
	public IconDTO update(Long id, IconDTO iconDTO) {
		Optional<IconEntity> entity = this.iconRepository.findById(id); // Buscamos por id el icono a modificar
		
		if (!entity.isPresent()) {
//			throw new ParamNotFound("Id icono no valido"); // Si no fue encontrado un icon lanzamos excepcion
		}
		this.iconMapper.iconEntityUpdate(entity.get(), iconDTO); // Hacemos la modificacion
		
		IconEntity entitySaved = this.iconRepository.save(entity.get()); // Guardamos en la BD
		IconDTO result = this.iconMapper.iconEntity2DTO(entitySaved, false); //  Pasamos a dto
		
		return result;
	}

	public void delete(Long id) {
		this.iconRepository.deleteById(id);
	}

	public void addPais(Long id, Long idPais) {
		IconEntity entity = this.iconRepository.getById(id);
        entity.getPaises().size();
        
        PaisEntity paisEntity = this.paisService.getEntityById(idPais);
        entity.addPais(paisEntity);
        
        this.iconRepository.save(entity);
	}
	
	

	public void removePais(Long id, Long idPais) {
		IconEntity entity = this.iconRepository.getById(id); // Buscamos la Entidad
		entity.getPaises().size();
		
		PaisEntity paisEntity = this.paisService.getEntityById(idPais); // Buscamos el pais al que corresponde el id
		entity.removePais(paisEntity); // Eliminamos el pais
		
		this.iconRepository.save(entity); // Actualizamos datos
	}

}
