package com.loanapplication.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loanapplication.project.model.Customer;
import com.loanapplication.project.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {


		@Autowired(required = true)
		CustomerService customerService;


		// Adding Customer

		@PostMapping
		public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
			return new ResponseEntity<Customer>(customerService.addCustomer(c), HttpStatus.OK);
		}

		// Updating Customer

		@PutMapping
		public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
			return new ResponseEntity<Customer>(customerService.updateCustomer(c), HttpStatus.OK);
		}

		// Fetching all Customers

		

		// Customer Login

		@PostMapping("/login")
		public ResponseEntity<Integer> doLogin(@RequestParam String email, @RequestParam String password) {
			return new ResponseEntity<Integer>(customerService.doLogin(email, password), HttpStatus.OK);
		}

		// Fetching Customer By Customer Id

		@GetMapping("/{id}")
		public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
			return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
		}

}
