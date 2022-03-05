package com.lucarinelli.usersmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<UsersResponseDto> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/users/{id}")
	public UsersResponseDto getUserById(@PathVariable String id){
		return service.getById(id);
	}
	
	@GetMapping("/users/codicefiscale/{codiceFiscale}")
	public UsersResponseDto getUserByCodiceFiscale(@PathVariable String codiceFiscale) {
		System.out.println(service.getByCodiceFiscale(codiceFiscale).getCodiceFiscale());
		return service.getByCodiceFiscale(codiceFiscale);
	}
	
	@PostMapping("/users")
	public UsersResponseDto creaUser(@RequestBody @Validated UsersRequestDto request){
		return service.creaUser(request);
	}
	
	@PutMapping("/users/codicefiscale/{codiceFiscale}")
	public UsersResponseDto modificaUser(@PathVariable String codiceFiscale, @RequestBody @Validated UsersRequestDto request) {
		return service.modificaUser(codiceFiscale, request);
	}
	
	@DeleteMapping("/users/codicefiscale/{codiceFiscale}")
	public void eliminaUser(String codiceFiscale) {
		service.eliminaUser(codiceFiscale);
	}

}
