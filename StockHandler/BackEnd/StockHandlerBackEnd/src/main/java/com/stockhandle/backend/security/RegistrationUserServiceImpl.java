package com.stockhandle.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stockhandle.backend.model.User;
import com.stockhandle.backend.repository.UserRepository;

@Service
public class RegistrationUserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public User save(User user) {

		if (user!=null) {
			user.setUsername(user.getUsername());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}

		return user;
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    return bCryptPasswordEncoder;
	}
	
}