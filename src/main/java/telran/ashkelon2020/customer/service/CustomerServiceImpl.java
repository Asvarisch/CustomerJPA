package telran.ashkelon2020.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.customer.dao.AccountRepository;
import telran.ashkelon2020.customer.dao.CustomerRepository;
import telran.ashkelon2020.customer.dao.SubscriberRepository;
import telran.ashkelon2020.customer.dto.CustomerDto;
import telran.ashkelon2020.customer.dto.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.customer.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SubscriberRepository subscriberRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public boolean addCustomer(CustomerDto customerDto) {
		if (customerRepository.existById(customerDto.getCustomerName())) {
			return false;
		}
		Customer customer = modelMapper.map(customerDto, Customer.class); //new Customer(customerDto.getCustomerName(), customerDto.getCity());
		customerRepository.save(customer);
		return true;
	}

	@Override
	public CustomerDto findCustomerByName(String customerName) {
		Customer customer = customerRepository.findById(customerName).orElseThrow(() -> new DocumentNotFoundException());
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	@Transactional
	public CustomerDto deleteCustomer(String customerName) {
		Customer customer = customerRepository.findById(customerName).orElseThrow(() -> new DocumentNotFoundException());
		customerRepository.delete(customer);
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	@Transactional
	public CustomerDto updateCustomer(String customerName, String city) {
		Customer customer = customerRepository.findById(customerName).orElseThrow(() -> new DocumentNotFoundException());
		customer.setCity(city);
		return modelMapper.map(customer, CustomerDto.class);
	}

	
	

}
