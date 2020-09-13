package telran.ashkelon2020.customer.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.customer.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean existById(String customerName) {
		return em.find(Customer.class, customerName) != null;
	}

	@Override
	public Customer save(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public Optional<Customer> findById(String customerName) {
		return Optional.ofNullable(em.find(Customer.class, customerName));
	}

	@Override
	public void delete(Customer customer) {
		em.remove(customer);
		
	}
	
	
	

}
