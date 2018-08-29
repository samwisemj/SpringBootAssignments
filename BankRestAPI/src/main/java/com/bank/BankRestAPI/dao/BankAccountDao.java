package com.bank.BankRestAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.BankRestAPI.pojo.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, Integer> {

}
