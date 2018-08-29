package com.bank.BankRestAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.BankRestAPI.dao.BankAccountDao;
import com.bank.BankRestAPI.pojo.BankAccount;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountDao dao;
	public void add(BankAccount account)
	{
		dao.save(account);
	}
}
