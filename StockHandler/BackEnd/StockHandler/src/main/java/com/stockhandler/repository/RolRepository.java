package com.stockhandler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockhandler.model.RolEntity;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer>{

	@Query("select r from RolEntity r")
	List<RolEntity> getAllRol();
	
}
