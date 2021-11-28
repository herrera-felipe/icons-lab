package com.alkemy.icons.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDTO {

		private Long id;
		private String imagen;
		private String denominacion;
		private Long cantidadHabitantes;
		private Long superficie;
		private Long continenteId;
//		private List<IconDTO> icons;
}
