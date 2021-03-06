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
	public CommandLineRunner loadTheData(CustomerService service)
	{
		return (args)->{
			service.add(1, "Subhamoy", "Kolkata");
			service.add(2, "Alfaiz", "Pune");
			service.add(3, "Mehul", "Mumbai");
			service.add(4, "Amit", "Kolkata");
			service.add(5, "Abhirup", "Mumbai");
			service.add(6, "Arijeet", "Chennai");
			System.out.println("Sample Data Populated");
		};
		
	}
}
