package com.loanapplication.project.service.serviceimpl;

import java.util.List;

import javax.persistence.PrimaryKeyJoinColumn;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Primary;

import org.springframework.stereotype.Service;

import com.loanapplication.project.exception.CustomerAlreadyRegisteredException;
import com.loanapplication.project.exception.CustomerNotFoundException;
import com.loanapplication.project.model.Customer;
import com.loanapplication.project.repository.CustomerRepository;
import com.loanapplication.project.service.CustomerService;
@Service
@Primary 

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerDao;

	

	@Override
	public Customer addCustomer(Customer c) {
		Customer customer = customerDao.checkCustomer(c.getEmail(), c.getAdhaar(), c.getPan(), c.getPhone());
		if (customer != null) {
			throw new CustomerAlreadyRegisteredException("Customer Already Registered: " + customer.getId());
		}
		return customerDao.save(customer);
	}

	@Override
	public Integer doLogin(String email, String password) {
		Integer customerId = null;
		try {
			customerId = customerDao.findCustomerByEmailAndPassword(email, password);
			
			return customerId;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer Not Found: " + customerId);
		}
	}
    @Override
	public Customer updateCustomer(Customer c) {
		Customer customer = customerDao.findById(c.getId());
				if(customer==null) {
				throw new CustomerNotFoundException("Customer Not Found: " + c.getId());
				}
		BeanUtils.copyProperties(c, customer);
		return customerDao.save(customer);
	}

	

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = customerDao.findById(customerId);
				if(customer==null) {
				throw new CustomerNotFoundException("Customer Not Found: " + customerId);
				}
		return customer;
	}

	
}
