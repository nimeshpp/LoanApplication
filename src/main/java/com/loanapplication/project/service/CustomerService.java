package com.loanapplication.project.service;

import java.util.List;

import com.loanapplication.project.model.Customer;

public interface CustomerService {
	public Integer doLogin(String email, String password);

	public Customer addCustomer(Customer c);

	public Customer updateCustomer(Customer c);

	

	public Customer getCustomerById(int custId);

}
