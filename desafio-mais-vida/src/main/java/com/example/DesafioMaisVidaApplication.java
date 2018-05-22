package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.User;

@SpringBootApplication
@EnableAuthorizationServer
public class DesafioMaisVidaApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(DesafioMaisVidaApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<DesafioMaisVidaApplication> applicationClass = DesafioMaisVidaApplication.class;
}
