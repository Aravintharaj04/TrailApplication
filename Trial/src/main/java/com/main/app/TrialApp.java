package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.main.*"})
public class TrialApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				SpringApplication.run(TrialApp.class, args);
	}

}