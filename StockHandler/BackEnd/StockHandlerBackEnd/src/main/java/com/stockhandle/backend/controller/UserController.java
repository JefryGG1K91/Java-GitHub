package com.stockhandle.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.stockhandle.backend.exception.ResourceNotFoundException;
import com.stockhandle.backend.model.User;
import com.stockhandle.backend.repository.UserRepository;
import com.stockhandle.backend.security.RegistrationUserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RegistrationUserServiceImpl regImp;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public User createRol(@Valid @RequestBody User user) {
		return regImp.save(user);
	}

	@GetMapping("/usersbyname/{username}")
	@ResponseBody
	public User getUserByUserName(@PathVariable("username") String username) {
		return userRepository.findByUsername(username);
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		userRepository.delete(user);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") Integer id, @Valid @RequestBody User userDetails) {

		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		user.setPassword(userDetails.getPassword());

		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

}
