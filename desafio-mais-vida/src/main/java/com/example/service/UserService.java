package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.config.ApplicationConfigurationProperties;
import com.example.entities.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private ApplicationConfigurationProperties configurationProperties;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private UserRepository userRepository;

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User save(User user) throws Exception {
    	Optional<User> userOptional = userRepository.findByUserName(user.getUserName());
    	if (userOptional.isPresent()) {
            throw new Exception("Usuário existente");
        }

        user.setPassword(
                encryptPassword(user.getPassword())
        );

        user.setRoles(configurationProperties.getDefaultUserRoles());
        return userRepository.save(user);
    }


    public void delete(User user) {
        userRepository.delete(user);
    }

    private String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
