package com.example.demo;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.AppUser;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, AccountService accountService) {
		return args -> {
			// Seed products
			productRepository.save(new Product(null, "Computer", 3500, 10));
			productRepository.save(new Product(null, "Printer", 1200, 5));
			productRepository.save(new Product(null, "SmartPhone", 2500, 8));
			productRepository.findAll().forEach(p -> System.out.println(p.toString()));

			// Seed roles
			accountService.addNewRole(new AppRole(null, "ROLE_USER"));
			accountService.addNewRole(new AppRole(null, "ROLE_ADMIN"));

			// Seed users
			accountService.addNewUser(new AppUser(null, "user1", "1234", true, new ArrayList<>()));
			accountService.addNewUser(new AppUser(null, "admin", "1234", true, new ArrayList<>()));

			// Assign roles
			accountService.addRoleToUser("user1", "ROLE_USER");
			accountService.addRoleToUser("admin", "ROLE_ADMIN");
			accountService.addRoleToUser("admin", "ROLE_USER");
		};
	}
}
