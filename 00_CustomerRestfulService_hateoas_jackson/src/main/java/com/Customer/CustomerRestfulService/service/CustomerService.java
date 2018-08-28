package com.Customer.CustomerRestfulService.service;

import java.util.ArrayList;

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
		customerDao.add(id, name, address);
	}

	public void update(int id, String name, String address) {
		customerDao.update(id, name, address);
	}

	public ArrayList<Customer> viewAl() {
		return customerDao.getAllCustomer();
	}

	public void delete(int id) {
		customerDao.remove(id);
	}
}
