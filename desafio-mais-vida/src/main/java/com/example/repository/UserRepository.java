package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.entities.User;


public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByUserName(String userName);
}
