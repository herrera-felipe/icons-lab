package com.alkemy.icons.service;

import java.util.List;

import com.alkemy.icons.dto.ContinenteDTO;

public interface ContinenteService {

	public ContinenteDTO save(ContinenteDTO dto);

	public List<ContinenteDTO> getAllContinentes();
}
