package com.main.app;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication()
@ComponentScan("com.main.*")
@EntityScan("com.main.*")
@EnableJpaRepositories("com.main.repository")
public class TrialApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Logger log = LoggerFactory.getLogger(TrialApp.class);
				SpringApplication.run(TrialApp.class, args);
				
				log.info("Application started for TrailApp");
				
	}

}