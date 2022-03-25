package com.lucarinelli.usersmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResponseDto {
	
	private String id;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Integer eta;
	private String sesso;

}
