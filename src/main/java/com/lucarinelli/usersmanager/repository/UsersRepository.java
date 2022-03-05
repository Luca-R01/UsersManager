package com.lucarinelli.usersmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucarinelli.usersmanager.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
	
	public Users findByCodiceFiscale(String codiceFiscale);

}
