package com.example.expenseTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.example.expenseTracker.repository"})
//@ComponentScan(basePackages = {"com.example.expenseTracker.controller", "com.example.expenseTracker.auth", "com.example.expenseTracker.service",
//        "com.example.expenseTracker.eventProducer"})
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

}
