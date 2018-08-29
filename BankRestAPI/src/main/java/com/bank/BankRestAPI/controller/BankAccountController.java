package com.bank.BankRestAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.BankRestAPI.pojo.BankAccount;
import com.bank.BankRestAPI.service.BankAccountService;

@RestController
public class BankAccountController {

	@Autowired
	private BankAccountService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addAccount(BankAccount account) {
		service.add(account);
	}
}
