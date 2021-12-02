package com.alkemy.icons.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.icons.entity.IconEntity;

@Repository
public interface IconRepository extends JpaRepository<IconEntity, Long> {

	List<IconEntity> findAll(Specification<IconEntity> specification);
}
