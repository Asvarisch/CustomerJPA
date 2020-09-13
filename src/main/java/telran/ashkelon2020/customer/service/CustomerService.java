package telran.ashkelon2020.customer.service;

import telran.ashkelon2020.customer.dto.CustomerDto;

public interface CustomerService {

	boolean addCustomer(CustomerDto customerDto);

	CustomerDto findCustomerByName(String customerName);

	CustomerDto deleteCustomer(String customerName);

	CustomerDto updateCustomer(String customerName, String city);

	

	

}
