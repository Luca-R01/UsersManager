package com.lucarinelli.usersmanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersRepository repository;

	@Override
	public List<UsersResponseDto> getAll() {
		logger.info("Richiamato il metodo 'getAll' ");
		List<Users> usersList = repository.findAll();
		List<UsersResponseDto> dtoList = UsersMapper.toDtoList(usersList);
		return dtoList;
	}

	@Override
	public UsersResponseDto getById(String id) {
		logger.info("Richiamato il metodo 'getById' ");
		Users user = repository.findById(id).orElseThrow( () -> new UsersNotFoundException(id));
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto getByCodiceFiscale(String codiceFiscale) {
		logger.info("Richiamato il metodo 'getByCodiceFiscale' ");
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		UsersResponseDto dto = UsersMapper.toDto(user);
		return dto;
	}

	@Override
	public UsersResponseDto creaUser(UsersRequestDto dto) {
		logger.info("Richiamato il metodo 'creaUser' ");
		Users user = UsersMapper.ToUser(dto);
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
		logger.info("Richiamato il metodo 'modificaUser' ");
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		
		user.setCodiceFiscale(dto.getCodiceFiscale());
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setEta(dto.getEta());
		user.setSesso(dto.getSesso());

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
		logger.info("Richiamato il metodo 'eliminaUser' ");
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		repository.delete(user);
	}

}
