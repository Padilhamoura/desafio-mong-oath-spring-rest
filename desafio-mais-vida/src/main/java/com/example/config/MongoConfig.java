package com.example.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;



@Configuration
public class MongoConfig {

	private final MongoDbFactory mongo;
	
	@Autowired
	public MongoConfig(MongoDbFactory mongo) {
		this.mongo = mongo;
	}
}