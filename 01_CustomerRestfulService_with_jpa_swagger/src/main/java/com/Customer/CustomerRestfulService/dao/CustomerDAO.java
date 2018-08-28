package com.Customer.CustomerRestfulService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Customer.CustomerRestfulService.pojo.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}