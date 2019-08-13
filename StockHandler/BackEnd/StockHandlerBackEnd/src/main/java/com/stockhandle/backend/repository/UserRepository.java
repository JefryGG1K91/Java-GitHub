package com.stockhandle.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stockhandle.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(@Param("username") String username);
//	Optional<User> findByUsernameOptional(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);

}
