package com.alkemy.icons.service;

import java.util.List;

import com.alkemy.icons.dto.PaisDTO;
import com.alkemy.icons.entity.PaisEntity;

public interface PaisService {
	
	public PaisDTO save(PaisDTO dto);
	
	public List<PaisDTO> getAllPaises();

	public PaisEntity getEntityById(Long idPais);

}
