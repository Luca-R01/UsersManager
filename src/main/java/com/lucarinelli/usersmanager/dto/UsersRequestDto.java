package com.lucarinelli.usersmanager.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UsersRequestDto {
	
	private enum Sesso {
		M,
		m,
		F,
		f
	}

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
	@NotNull
	private String sesso;
	
	public UsersRequestDto() {}

	public UsersRequestDto(String codiceFiscale, String nome, String cognome, Integer eta, Sesso sesso) {
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso.toString();
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public String getSesso() {
		return sesso.toString();
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso.toString();
	}

	public void setSessoString(String sesso) {
		this.sesso = sesso;
	}
}
