package com.lucarinelli.usersmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.lucarinelli.usersmanager.model.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
	
	public Optional<Users> findByCodiceFiscale(String codiceFiscale);

}
