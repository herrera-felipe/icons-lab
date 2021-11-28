package com.alkemy.icons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.mapper.PaisMapper;
import com.alkemy.icons.repository.PaisRepository;
import com.alkemy.icons.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService {

	@Autowired
	private PaisMapper paisMapper;
	
	@Autowired
	private PaisRepository paisRepository;
	
	public PaisDTO save(PaisDTO dto) {
		PaisEntity entity = paisMapper.paisDTO2Entity(dto); // parseo a entidad para persistir
		PaisEntity entitySaved = paisRepository.save(entity); // persistimos a bd
		PaisDTO result = paisMapper.paisEntity2DTO(entitySaved); // parseo a dto para return
		return result; // retornamos el dto
	}

	public List<PaisDTO> getAllPaises() {
		List<PaisEntity> entities = paisRepository.findAll(); // consulta a la db y almacenamos en una lista
		List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities);
		return result;
	}

}
