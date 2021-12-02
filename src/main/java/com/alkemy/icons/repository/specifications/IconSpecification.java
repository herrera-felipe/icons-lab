package com.alkemy.icons.repository.specifications;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alkemy.icons.dto.IconFiltersDTO;
import com.alkemy.icons.entity.IconEntity;
import com.alkemy.icons.entity.PaisEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class IconSpecification {

	public Specification<IconEntity> getByFilters(IconFiltersDTO filtersDTO) {
		return (root, query, criteriaBuilder) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.hasLength(filtersDTO.getNombre())) {
				
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("denominacion")),
						"%" + filtersDTO.getNombre().toLowerCase() + "%"));
			}

			if (StringUtils.hasLength(filtersDTO.getFechaCreacion())) {
				// TODO: Reuse this in a function
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				
				LocalDate date = LocalDate.parse(filtersDTO.getFechaCreacion(), formatter);

				predicates.add(criteriaBuilder.equal(root.<LocalDate>get("fechaCreacion"), date));
			}

			if (!CollectionUtils.isEmpty(filtersDTO.getPaises())) {
				
				Join<PaisEntity, IconEntity> join = root.join("paises", JoinType.INNER);
				
				Expression<String> paisesId = join.get("id");
				
				predicates.add(paisesId.in(filtersDTO.getPaises()));
			}

			// Remueve Duplicados
			query.distinct(true);

			// Orden en que sera mostrado
			String orderByField = "denominacion";
			
			query.orderBy(filtersDTO.isASC() ? 
					criteriaBuilder.asc(root.get(orderByField)) : 
					criteriaBuilder.desc(root.get(orderByField)));

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
