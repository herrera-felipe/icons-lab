package com.alkemy.icons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.dto.ContinenteDTO;
import com.alkemy.icons.entity.ContinenteEntity;
import com.alkemy.icons.mapper.ContinenteMapper;
import com.alkemy.icons.repository.ContinenteRepository;
import com.alkemy.icons.service.ContinenteService;

@Service
public class ContinenteServiceImpl implements ContinenteService {

	@Autowired
	private ContinenteMapper continenteMapper;
	
	@Autowired
	private ContinenteRepository continenteRepository;
	
	
	public ContinenteDTO save(ContinenteDTO dto) {
		ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto); // Convertimos el dto a entidad con el mapper para poder guardarlo
		ContinenteEntity entitySaved = continenteRepository.save(entity); // guardamos el continente en la BD, y a su vez lo almacenamos en la variable entitySaved
		ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved); // Convertimos la entidad persistida a DTO para retornarla al controller
		return result;
	}

	public List<ContinenteDTO> getAllContinentes() {
		List<ContinenteEntity> entities = continenteRepository.findAll(); // Obtenemos la lista de entidades de la BD
		List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities); // Con el mapper convertimos a un DTO y poder retornarlo al controller
		return result;
	}
}
