package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;

@SpringBootApplication
@RestController
@EnableOAuth2Client
@EnableAuthorizationServer
public class DesafioMaisVidaApplication {

	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioMaisVidaApplication.class, args);
		User savedUser;
        try {
            savedUser = userService.save(userDto, userName);
	}
}
