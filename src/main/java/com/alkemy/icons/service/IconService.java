package com.alkemy.icons.service;

import java.util.List;

import com.alkemy.icons.dto.IconDTO;

public interface IconService {

	public IconDTO save(IconDTO dto);
	
	public List<IconDTO> getAllIcons();
	
	public IconDTO getDetailsById(Long id);

	public IconDTO update(Long id, IconDTO icon);

	public void delete(Long id);

	public void addPais(Long id, Long idPais);

	public void removePais(Long id, Long idPais);
}
