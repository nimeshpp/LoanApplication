package com.loanapplication.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanapplication.project.model.Transaction;
import com.loanapplication.project.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionController {
	@Autowired(required = true)
	private TransactionService transactionService;

	@PostMapping("/")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction trans) {
		return new ResponseEntity<Transaction>(transactionService.addTransaction(trans), HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Transaction>> getTransactionsByCustId(@PathVariable int id) {
		return new ResponseEntity<List<Transaction>>(transactionService.getTransactionsByCustId(id), HttpStatus.OK);
	}

}
