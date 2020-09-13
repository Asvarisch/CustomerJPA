package telran.ashkelon2020.customer.dao;

import java.util.Optional;

import telran.ashkelon2020.customer.model.Customer;

public interface CustomerRepository {

	boolean existById(String customerName);

	Customer save(Customer customer);

	Optional<Customer> findById(String customerName);

	void delete(Customer customer);

}
