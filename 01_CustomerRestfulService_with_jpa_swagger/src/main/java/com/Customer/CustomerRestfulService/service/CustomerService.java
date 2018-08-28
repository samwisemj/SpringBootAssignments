package com.Customer.CustomerRestfulService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Customer.CustomerRestfulService.dao.CustomerDAO;
import com.Customer.CustomerRestfulService.pojo.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(int id, String name, String address) {
		customerDao.save(new Customer(id, name, address));
	}

	public void update(int id, String name, String address) {
		customerDao.save(new Customer(id, name, address));
	}

	public ArrayList<Customer> viewAl() {
		return (ArrayList<Customer>) customerDao.findAll();
	}

	public void delete(int id) {
		customerDao.deleteById(id);
	}
}
