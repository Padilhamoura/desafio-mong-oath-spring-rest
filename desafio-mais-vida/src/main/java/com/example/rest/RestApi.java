package com.example.rest;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;
import com.example.service.UserService;

@RestController
public class RestApi {
	
	@Autowired
	UserService userservice;
	
	@RequestMapping("/user-api")
	public Principal user(Principal principal) {
		return principal;
	}
	
	@RequestMapping("/user-create")
	public @ResponseBody ResponseEntity<?> createUser(Principal principal) {
		User user = new User();
		user.setUserName("Admin");
		user.setPassword("123456");
		
		try {
			userservice.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok().body(user.getUserName());
	}
	
	@RequestMapping("/user-list")
	public @ResponseBody ResponseEntity<?> listUser(){
		return ResponseEntity.ok().body(userservice.findAll());
	}
	
}
