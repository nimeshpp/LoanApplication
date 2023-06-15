package com.loanapplication.project.service;

import java.util.List;

import com.loanapplication.project.model.Transaction;

public interface TransactionService {
	public Transaction addTransaction(Transaction trans);

	public List<Transaction> getTransactionsByCustId(int custId);
}
