package com.example.demo;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Computer", 3500, 10));
			productRepository.save(new Product(null, "Printer", 1200, 5));
			productRepository.save(new Product(null, "SmartPhone", 2500, 8));
			productRepository.findAll().forEach(p -> System.out.println(p.toString()));
		};
	}
}
