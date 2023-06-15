package com.loanapplication.project.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.loanapplication.project.exception.CustomerNotFoundException;
import com.loanapplication.project.exception.LoanNotFoundException;
import com.loanapplication.project.model.Customer;
import com.loanapplication.project.model.Loan;
import com.loanapplication.project.repository.CustomerRepository;
import com.loanapplication.project.repository.LoanRepository;
import com.loanapplication.project.service.LoanService;


@Service
@Primary
public class LoanServiceImpl implements LoanService{
	@Autowired
	private LoanRepository loanDao;

	@Autowired
	private CustomerRepository customerDao;

	//private Logger logger = Logger.getLogger(getClass());

	public Loan applyLoan(Loan loan) {
		int customerId = loan.getCustomer().getId();
		Customer customer = customerDao.findById(customerId);
		if(customer==null) {
				throw new CustomerNotFoundException("Cusotmer Not Found: " + customerId);
		}
		customer.addLoan(loan);
		return loanDao.save(loan);
	}

	@Override
	public List<Loan> getLoansByCustomerId(int customerId) {
		Customer customer = customerDao.findById(customerId);
		if(customer==null) {
				throw new CustomerNotFoundException("Customer Not Found: " + customerId);
		}
		return customer.getLoans();
	}

	@Override
	public void foreCloseLoan(int loanId) {
			loanDao.deleteById(loanId);
	}

	

	

	
}
