package com.Customer.CustomerRestfulService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Customer.CustomerRestfulService.service.CustomerService;

@SpringBootApplication
public class CustomerRestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRestfulServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInitialData(CustomerService service) {
		return (args) -> {
			service.add(1, "Subhamoy", "Kolkata");
			service.add(2, "Mehul", "Kolkata");
			service.add(3, "Alfaiz", "Patna");
			service.add(4, "Amit", "Patna");
			service.add(5, "Gregor", "Texas");
			service.add(6, "Satyen", "Mumbai");
			service.add(7, "Preeti", "Indore");
			service.add(8, "Prashant", "Delhi");
			service.add(9, "Sumit", "Jodhpur");
			service.add(10, "Rakesh", "Navi Mumbai");
			service.add(11, "Freddie", "Queensland");
			System.out.println("Sample data populated");
		};
	}
}
