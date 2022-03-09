package com.lucarinelli.usersmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@GetMapping("/users")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable String id){
		UsersResponseDto response = service.getById(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping("/users/codicefiscale/{codiceFiscale}")
	public ResponseEntity<?> getUserByCodiceFiscale(@PathVariable String codiceFiscale) {
		UsersResponseDto response = service.getByCodiceFiscale(codiceFiscale);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> creaUser(@RequestBody @Validated UsersRequestDto request){
		return new ResponseEntity<>(service.creaUser(request), HttpStatus.OK);
	}
	
	@PutMapping("/users/codicefiscale/{codiceFiscale}")
	public ResponseEntity<?> modificaUser(@PathVariable String codiceFiscale, @RequestBody @Validated UsersRequestDto request) {
		return new ResponseEntity<>(service.modificaUser(codiceFiscale, request), HttpStatus.OK);
	}
	
	@DeleteMapping("/users/codicefiscale/{codiceFiscale}")
	public ResponseEntity<?> eliminaUser(String codiceFiscale) {
		service.eliminaUser(codiceFiscale);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
