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
import com.lucarinelli.usersmanager.utility.CalcoloCodiceFiscale;

@Service
public class UserServiceImpl implements UsersService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UsersRepository repository;

	@Override
	public List<UsersResponseDto> getAll() {
		logger.info("Richiamato il metodo 'getAll' ");

		return UsersMapper.toDtoList(repository.findAll());
	}

	@Override
	public UsersResponseDto getById(String id) {
		logger.info("Richiamato il metodo 'getById' ");

		return UsersMapper.toDto(repository.findById(id).orElseThrow( () -> new UsersNotFoundException(id)));
	}

	@Override
	public UsersResponseDto getByCodiceFiscale(String codiceFiscale) {
		logger.info("Richiamato il metodo 'getByCodiceFiscale' ");

		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		return UsersMapper.toDto(user);
	}

	@Override
	public UsersResponseDto creaUser(UsersRequestDto dto) {
		logger.info("Richiamato il metodo 'creaUser' ");

		Users user = UsersMapper.ToUser(dto);
		user.setCodiceFiscale(CalcoloCodiceFiscale.get(user.getCognome(), user.getNome(), user.getSesso(), user.getCittaNatale(), user.getDataDiNascita()));
		
		Optional<Users> userOptional = repository.findByCodiceFiscale(user.getCodiceFiscale());
		if(userOptional.isEmpty()){
			repository.save(user);
			return UsersMapper.toDto(user);
		}
		else {
			throw new UsersExistException(user.getCodiceFiscale());
		} 
	
	}

	@Override
	public UsersResponseDto modificaUser(String codiceFiscale, UsersRequestDto dto) {
		logger.info("Richiamato il metodo 'modificaUser' ");

		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setSesso(dto.getSesso());
		user.setCittaNatale(dto.getCittaNatale());
		user.setDataDiNascita(dto.getDataDiNascita());
		user.setCodiceFiscale(CalcoloCodiceFiscale.get(user.getCognome(), user.getNome(), user.getSesso(), user.getCittaNatale(), user.getDataDiNascita()));
		
		Optional<Users> userOptional = repository.findByCodiceFiscale(user.getCodiceFiscale());
		if(userOptional.isEmpty()){
			repository.save(user);
			return UsersMapper.toDto(user);
		}
		else {
			throw new UsersExistException(user.getCodiceFiscale());
		} 
	}

	@Override
	public void eliminaUser(String codiceFiscale) {
		logger.info("Richiamato il metodo 'eliminaUser' ");
		
		Users user = repository.findByCodiceFiscale(codiceFiscale).orElseThrow( () -> new UsersNotFoundException(codiceFiscale));
		repository.delete(user);
	}

	

}
