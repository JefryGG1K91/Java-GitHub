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
import org.springframework.web.bind.annotation.RestController;

import com.stockhandle.backend.exception.ResourceNotFoundException;
import com.stockhandle.backend.model.Rol;
import com.stockhandle.backend.repository.RolRepository;

@RestController
@RequestMapping("/api")
public class RolController {

	@Autowired
	private RolRepository repository;
	
	@GetMapping("/roles")
	public List<Rol> getAllRoles(){
		return repository.findAll();
	}
	
	@PostMapping("/roles")
	public Rol createRol(@Valid @RequestBody Rol rol) {
		return repository.save(rol);
	}
	
	@GetMapping("/roles/{id}")
	public Rol getRolById(@PathVariable(value = "id") Integer id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));
	}
	
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer id) {
		Rol rol = repository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));

		repository.delete(rol);

	    return ResponseEntity.ok().build();
	}
	
	@PutMapping("/roles/{id}")
	public Rol updateNote(@PathVariable(value = "id") Integer id,
	                                        @Valid @RequestBody Rol rolDetails) {

		Rol rol = repository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Rol", "id", id));

		rol.setDescription(rolDetails.getDescription());
		rol.setRolStatus(rolDetails.isRolStatus());

	    Rol updatedRol = repository.save(rol);
	    return updatedRol;
	}
	
}
