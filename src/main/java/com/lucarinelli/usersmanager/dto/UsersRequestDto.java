package com.lucarinelli.usersmanager.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersRequestDto {

	@NotNull
	private String nome;

	@NotNull
	private String cognome;

	@NotNull
	private String dataDiNascita;

	@NotNull
	private String cittaNatale;

	@Pattern(regexp = "M|F", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String sesso;

}
