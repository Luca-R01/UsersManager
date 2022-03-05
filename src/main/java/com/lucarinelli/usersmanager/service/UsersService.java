package com.lucarinelli.usersmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;

@Service
public interface UsersService {
	
	public List<UsersResponseDto> getAll();
	
	public UsersResponseDto getById(String id);
	
	public UsersResponseDto getByCodiceFiscale(String codiceFiscale);
	
	public UsersResponseDto creaUser(UsersRequestDto dto);
	
	public UsersResponseDto modificaUser(String codiceFiscale, UsersRequestDto dto);
	
	public void eliminaUser(String codiceFiscale);
}
