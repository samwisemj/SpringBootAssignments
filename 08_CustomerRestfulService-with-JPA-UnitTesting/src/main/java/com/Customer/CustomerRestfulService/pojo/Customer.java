package com.Customer.CustomerRestfulService.pojo;

import javax.persistence.*;

@Entity
public class Customer {

	@Id
	private Integer id;
	
	private String name;
	private String address;
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public Customer() {
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Customer(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public Customer(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
