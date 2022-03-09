package com.lucarinelli.usersmanager.exception;

import com.lucarinelli.usersmanager.controller.UsersController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersExistException extends RuntimeException{

    private Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UsersExistException(String codiceFiscale){
        super(String.format("L'utente con codice fiscale " + codiceFiscale + " Esiste già"));
        logger.error("L'utente con codice fiscale " + codiceFiscale + " Esiste già");
    }
    
}
