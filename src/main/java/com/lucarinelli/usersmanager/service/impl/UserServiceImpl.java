package com.lucarinelli.usersmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.mapper.UsersMapper;
import com.lucarinelli.usersmanager.model.Users;
import com.lucarinelli.usersmanager.repository.UsersRepository;
import com.lucarinelli.usersmanager.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository repository;

	@Override
	public List<UsersResponseDto> getAll() {
		List<Users> usersList = repository.findAll();
		List<UsersResponseDto> dtoList = UsersMapper.toDtoList(usersList);
		return dtoList;
	}

	@Override
	public UsersResponseDto getById(String id) {
		Users user = repository.findById(id).get();
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto getByCodiceFiscale(String codiceFiscale) {
		Users user = repository.findByCodiceFiscale(codiceFiscale);
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto creaUser(UsersRequestDto dto) {
		Users user = UsersMapper.ToUser(dto);
		List <Users> usersList = repository.findAll();
		for (Integer i=0; i<usersList.size(); i++) {
			if (dto.getCodiceFiscale().equals(usersList.get(i).getCodiceFiscale())) {
				user = null;
			}
		}
		repository.save(user);
		UsersResponseDto response = UsersMapper.toDto(user);
		return response;
	
	}

	@Override
	public UsersResponseDto modificaUser(String codiceFiscale, UsersRequestDto dto) {
		Users user = repository.findByCodiceFiscale(codiceFiscale);
		
		user.setCodiceFiscale(dto.getCodiceFiscale());
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setEta(dto.getEta());
		user.setSesso(dto.getSesso());
		
		List <Users> usersList = repository.findAll();
		for (Integer i=0; i<usersList.size(); i++) {
			if (dto.getCodiceFiscale().equals(usersList.get(i).getCodiceFiscale())) {
				user = null;
			}
		}
		
		repository.save(user);
		UsersResponseDto userDto = UsersMapper.toDto(user);
		return userDto;
	}

	@Override
	public void eliminaUser(String codiceFiscale) {
		Users user = repository.findByCodiceFiscale(codiceFiscale);
		repository.delete(user);
	}

}
