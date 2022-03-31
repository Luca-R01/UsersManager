package com.lucarinelli.usersmanager.mapper;

import java.util.ArrayList;
import java.util.List;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.model.Users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersMapper {

	private static Logger logger = LoggerFactory.getLogger(UsersMapper.class);
	
	public static Users ToUser(UsersRequestDto dto) {
		logger.info("Richiamato 'UserMapper toUser' ");
		Users user = new Users();
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setDataDiNascita(dto.getDataDiNascita());
		user.setCittaNatale(dto.getCittaNatale());
		user.setSesso(dto.getSesso());
		return user;
	}
	
	public static UsersResponseDto toDto (Users user) {
		logger.info("Richiamato 'UserMapper toDto' ");
		UsersResponseDto dto = new UsersResponseDto();
		dto.setId(user.getId());
		dto.setCodiceFiscale(user.getCodiceFiscale());
		dto.setNome(user.getNome());
		dto.setCognome(user.getCognome());
		dto.setEta(user.getEta());
		dto.setSesso(user.getSesso());
		return dto;	
	}
	
	public static List<UsersResponseDto> toDtoList(List<Users> usersList){
		logger.info("Richiamato 'UserMapper toDtoList' ");
		List<UsersResponseDto> dtoList = new ArrayList<UsersResponseDto>();
		for (Users user : usersList){
			dtoList.add(toDto(user));
		}
		return dtoList; 
	}

}
