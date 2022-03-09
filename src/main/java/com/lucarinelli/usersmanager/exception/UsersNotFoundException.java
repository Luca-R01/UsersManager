package com.lucarinelli.usersmanager.exception;

import com.lucarinelli.usersmanager.controller.UsersController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersNotFoundException extends RuntimeException {

	private Logger logger = LoggerFactory.getLogger(UsersController.class);

	public UsersNotFoundException(String id) {
		super(String.format("Utente non trovato"));
		logger.error("Utente non trovato");
	}

}
