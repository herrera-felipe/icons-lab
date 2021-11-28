package com.alkemy.icons.service;

import java.util.List;

import com.alkemy.icons.dto.PaisDTO;

public interface PaisService {
	
	public PaisDTO save(PaisDTO dto);
	
	public List<PaisDTO> getAllPaises();

}
