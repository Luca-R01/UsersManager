package com.lucarinelli.usersmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.exception.UsersExistException;
import com.lucarinelli.usersmanager.exception.UsersNotFoundException;
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
		Users user = repository.findById(id).orElseThrow( () -> new UsersNotFoundException(id));
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto getByCodiceFiscale(String codiceFiscale) {
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto creaUser(UsersRequestDto dto) {
		Users user = UsersMapper.ToUser(dto);
		/* List <Users> usersList = repository.findAll();
		for (Integer i=0; i<usersList.size(); i++) {
			if (dto.getCodiceFiscale().equals(usersList.get(i).getCodiceFiscale())) {
				throw new UsersExistException(dto.getCodiceFiscale());
			}
		} */

		Optional<Users> userOptional = repository.findByCodiceFiscale(dto.getCodiceFiscale());
		if(userOptional.isEmpty()){
			repository.save(user);
			UsersResponseDto response = UsersMapper.toDto(user);
			return response;
		}
		else {
			throw new UsersExistException(dto.getCodiceFiscale());
		} 
	
	}

	@Override
	public UsersResponseDto modificaUser(String codiceFiscale, UsersRequestDto dto) {
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		
		user.setCodiceFiscale(dto.getCodiceFiscale());
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setEta(dto.getEta());
		user.setSesso(dto.getSesso());
		
		/* List <Users> usersList = repository.findAll();
		for (Integer i=0; i<usersList.size(); i++) {
			if (dto.getCodiceFiscale().equals(usersList.get(i).getCodiceFiscale())) {
				user = null;
			}
		} */

		Optional<Users> userOptional = repository.findByCodiceFiscale(dto.getCodiceFiscale());
		if(userOptional.isEmpty()){
			repository.save(user);
			UsersResponseDto response = UsersMapper.toDto(user);
			return response;
		}
		else {
			throw new UsersExistException(dto.getCodiceFiscale());
		} 
	}

	@Override
	public void eliminaUser(String codiceFiscale) {
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		repository.delete(user);
	}

}
