package com.lucarinelli.usersmanager.mapper;

import java.util.ArrayList;
import java.util.List;

import com.lucarinelli.usersmanager.dto.UsersRequestDto;
import com.lucarinelli.usersmanager.dto.UsersResponseDto;
import com.lucarinelli.usersmanager.model.Users;

public class UsersMapper {
	
	
	public static Users ToUser(UsersRequestDto dto) {
		Users user = new Users();
		user.setId(dto.getId());
		user.setCodiceFiscale(dto.getCodiceFiscale());
		user.setNome(dto.getNome());
		user.setCognome(dto.getCognome());
		user.setEta(dto.getEta());
		user.setSesso(dto.getSesso());
		return user;
	}
	
	public static UsersResponseDto toDto (Users user) {
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
		List<UsersResponseDto> dtoList = new ArrayList<UsersResponseDto>();
		for (Integer i=0; i<usersList.size(); i++) {
			UsersResponseDto dto = toDto(usersList.get(i));
			dtoList.add(dto);
		}
		return dtoList; 
	}

}
