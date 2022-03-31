package com.lucarinelli.usersmanager.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Users {
	
	@Id
	private String id;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Integer eta;
	private LocalDate dataDiNascita;
	private String cittaNatale;
	private String sesso;

	public void setDataDiNascita(String date){
		this.dataDiNascita = LocalDate.parse(date);
	}
}
