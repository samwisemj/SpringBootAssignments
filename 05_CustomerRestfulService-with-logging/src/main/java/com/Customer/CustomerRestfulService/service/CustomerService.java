package com.Customer.CustomerRestfulService.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Customer.CustomerRestfulService.dao.CustomerDao;
import com.Customer.CustomerRestfulService.pojo.Customer;

@Component
public class CustomerService {

	private static Logger logger=LogManager.getLogger(CustomerService.class);
	@Autowired
	private CustomerDao customerDao;

	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(int id, String name, String address) {
		logger.info("Inside service add");
		customerDao.save(new Customer(id, name, address));
		//customerDao.add(id, name, address);
	}

	public void update(int id, String name, String address) {
		logger.info("Inside service update");
		customerDao.save(new Customer(id, name, address));
	}

	public List<Customer> viewAll() {
		logger.info("Inside service viewall");
		return customerDao.findAll();
	}

	public void delete(int id) {
		logger.info("Inside service Delete");
		customerDao.deleteById(id);
	}
}
