package com.loanapplication.project.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;


import org.springframework.stereotype.Repository;


import com.loanapplication.project.model.Customer;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
	

	@Query("select c from Customer c where c.email=?1 or c.adhaar=?2 or c.pan=?3 or c.phone=?4")
	Customer checkCustomer(String email, long adhaar, String pan, long phone);

	@Query("select c.id from Customer c where c.email=?1 and c.password=?2")
	Integer findCustomerByEmailAndPassword(String email, String password);


	Customer findById(int id);

	
}
