package com.Customer.CustomerRestfulService.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.Customer.CustomerRestfulService.pojo.Customer;

public interface CustomerDao extends MongoRepository<Customer, String> {

	public Customer findByName();
	public List<Customer> findByAddress();
	public void deleteByCid(int id);
}
