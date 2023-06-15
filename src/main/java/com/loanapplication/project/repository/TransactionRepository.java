package com.loanapplication.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loanapplication.project.model.Loan;
import com.loanapplication.project.model.Transaction;
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	@Query("select t from Transaction t inner join Loan l on l.loanId=t.loan.loanId where l.customer.id=?1")
	List<Transaction> findTransactionsByCustomerId(int customerId);
 public Loan findById(int loanId);

}
