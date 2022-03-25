package com.lucarinelli.usersmanager.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	@Size(min=16, max=16)
	private String codiceFiscale;

	@NotNull
	private String nome;

	@NotNull
	private String cognome;

	@NotNull
	@Max(20)
	private Integer eta;

	@Pattern(regexp = "M|F", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String sesso;

}
