package com.stockhandle.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockhandle.backend.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
