package com.loanapplication.project.service;

import java.util.List;

import com.loanapplication.project.model.Customer;
import com.loanapplication.project.model.Loan;

public interface LoanService  {
	public Loan applyLoan(Loan l);
	

	public List<Loan> getLoansByCustomerId(int custId);

	public void foreCloseLoan(int loanId);

}
