package com.loanapplication.project.service.serviceimpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.loanapplication.project.exception.CustomerNotFoundException;
import com.loanapplication.project.exception.LoanNotFoundException;
import com.loanapplication.project.exception.TransactionFailedException;
import com.loanapplication.project.exception.TransactionsNotFoundException;
import com.loanapplication.project.model.Customer;
import com.loanapplication.project.model.Loan;
import com.loanapplication.project.model.Transaction;
import com.loanapplication.project.repository.CustomerRepository;
import com.loanapplication.project.repository.LoanRepository;
import com.loanapplication.project.repository.TransactionRepository;
import com.loanapplication.project.service.TransactionService;



@Service
@Primary
public class TrasactionServiceImpl implements TransactionService {

	
	@Autowired
	private CustomerRepository customerDao;

	@Autowired
	private LoanRepository loanDao;

	@Autowired
	private TransactionRepository transactionDao;



	public Transaction addTransaction(Transaction transaction) {
		int loanId = transaction.getLoan().getLoanId();
		Loan loan = loanDao.findById(loanId);
		if(loan==null) {
		throw new LoanNotFoundException("Loan Not Found: " + loanId);
		}
		loan.addTransaction(transaction);
		try {
			return transactionDao.save(transaction);
		} catch (Exception e) {
			throw new TransactionFailedException("Transaction Failed for LoanId: " + loanId);
		}
}



	@Override
	public List<Transaction> getTransactionsByCustId(int customerId) {
		Customer customer = customerDao.findById(customerId);
		if(customer==null) {
				throw new CustomerNotFoundException("Customer Not Found: " + customerId);
		}
		try {
			List<Transaction> transactions = transactionDao.findTransactionsByCustomerId(customerId);
			return transactions;
		} catch (Exception e) {
			throw new TransactionsNotFoundException("Transactions not Found for Customer Id: " + customerId);
		}}}
