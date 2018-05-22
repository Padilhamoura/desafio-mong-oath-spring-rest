package com.example.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	@RequestMapping("/userApi")
	public Principal user(Principal principal) {
		return principal;
	}
}
