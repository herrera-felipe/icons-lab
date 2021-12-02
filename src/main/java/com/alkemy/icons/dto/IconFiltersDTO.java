package com.alkemy.icons.dto;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconFiltersDTO {

	private String nombre;
	private String fechaCreacion;
	private Set<Long> paises;
	private String orden;
	
	public IconFiltersDTO(String nombre, String fechaCreacion, Set<Long> paises, String orden) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.paises = paises;
		this.orden = orden;
	}
	
	/*
	 * Orden Ascendente
	 */
	public boolean isASC() {
		return this.orden.compareToIgnoreCase("ASC") == 0;
	}
	
	/*
	 * Orde Descendente
	 */
	public boolean isDESC() {
		return this.orden.compareToIgnoreCase("DESC") == 0;
	}
	
}
