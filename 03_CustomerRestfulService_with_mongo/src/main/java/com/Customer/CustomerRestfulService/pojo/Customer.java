package com.Customer.CustomerRestfulService.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

 @Document(collection="MySampleCollectionOfCustomers")
public class Customer {

	@Id
	private String _id;

	private int cid;
	private String name;
	private String address;

	@Override
	public String toString() {
		return "Customer [id=" + cid + ", name=" + name + ", address=" + address + "]";
	}

	public Customer() {
	}

	public int getCid() {
		return cid;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Customer(int cid,String name, String address) {
		super();
		this.cid=cid;
		this.name = name;
		this.address = address;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
