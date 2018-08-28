package com.Customer.CustomerRestfulService.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.Customer.CustomerRestfulService.pojo.Customer;

@Component
public class CustomerDao {

	private ArrayList<Customer> customers;

	public CustomerDao() {
		super();
		customers=new ArrayList<>();
		customers.add(new Customer(1,"Alfaiz","Kolkata"));
		customers.add(new Customer(2,"Subhamoy","Kolkata"));
		customers.add(new Customer(3,"Mehul","mumbai"));
	}
	
	public void add(int id, String name, String address)
	{
		customers.add(new Customer(id,name,address));
	}
		
	public void remove(int id)
	{
		for(Customer customer:customers)
		{
			if(customer.getId()==id)
			{
				customers.remove(customer);
				break;
			}
		}
	}
	
	public void update(int id, String name, String address)
	{
		for(Customer customer:customers)
		{
			if(customer.getId()==id)
			{
				if(address!=null)
				customer.setAddress(address);
				if(name!=null)
				customer.setName(address);
			}
		}
	}
	
	public ArrayList<Customer> getAllCustomer()
	{
		return customers;
	}
	
}
