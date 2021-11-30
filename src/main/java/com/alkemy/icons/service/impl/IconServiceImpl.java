package com.alkemy.icons.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.icons.dto.IconDTO;
import com.alkemy.icons.entity.IconEntity;
import com.alkemy.icons.entity.PaisEntity;
import com.alkemy.icons.repository.IconRepository;
import com.alkemy.icons.service.IconService;
import com.alkemy.icons.service.PaisService;

@Service
public class IconServiceImpl implements IconService {
	
	@Autowired
	private IconRepository iconRepository;
	
	@Autowired
	private PaisService paisService;

	public IconDTO save(IconDTO dto) {
		// convertir el dto a entidad
		// Peristir a la bd con el repository
		// convertir el entity a dto para retornar 
		return null;
	}

	public List<IconDTO> getAllIcons() {
		// consultar a la bd
		// convertir lista a dto
		// retornar la lista dto
		return null;
	}

	public IconDTO getDetailsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public IconDTO update(Long id, IconDTO icon) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		this.iconRepository.deleteById(id);
	}

	public void addPais(Long id, Long idPais) {
		// TODO Auto-generated method stub
		
	}

	public void removePais(Long id, Long idPais) {
		IconEntity entity = this.iconRepository.getById(id); // Buscamos la Entidad
		entity.getPaises().size();
		PaisEntity paisEntity = this.paisService.getEntityById(idPais); // Buscamos el pais al que corresponde el id
		entity.removePais(paisEntity); // Eliminamos el pais
		this.iconRepository.save(entity); // Actualizamos datos
	}

}
