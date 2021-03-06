package com.Customer.CustomerRestfulService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Customer.CustomerRestfulService.dao.CustomerDao;
import com.Customer.CustomerRestfulService.pojo.Customer;

@Component
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(int id, String name, String address) {
		customerDao.save(new Customer(id, name, address));
		//customerDao.add(id, name, address);
	}

	public void update(int id, String name, String address) {
		customerDao.save(new Customer(id, name, address));
	}

	public List<Customer> viewAll() {
		return customerDao.findAll();
	}

	public void delete(int id) {
		customerDao.deleteByCid(id);
	}
}
