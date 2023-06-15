package com.loanapplication.project.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loanapplication.project.model.Customer;
import com.loanapplication.project.model.Loan;
@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

	@Query("select l from Loan l where l.id=?1")
	Customer findByCustomerId(int custId);

	public Loan findById(int id);

	


}
