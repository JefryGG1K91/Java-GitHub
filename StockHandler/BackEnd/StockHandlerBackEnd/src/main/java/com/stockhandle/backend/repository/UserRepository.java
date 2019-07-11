package com.stockhandle.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockhandle.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
