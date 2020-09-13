package telran.ashkelon2020.customer.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.customer.dto.CustomerDto;
import telran.ashkelon2020.customer.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer")
	public boolean addCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.addCustomer(customerDto);
	}
	
	@GetMapping("/customer/{customerName}")
	public CustomerDto findCustomer(@PathVariable String customerName) {
		return customerService.findCustomerByName(customerName);
	}
	
	@DeleteMapping("/customer/{customerName}")
	public CustomerDto deleteCustomer(@PathVariable String customerName) {
		return customerService.deleteCustomer(customerName);
	}
	
	@PutMapping("/customer/{customerName}/city/{city}")
	public CustomerDto updateCustomer(@PathVariable String customerName, @PathVariable String city) {
		return customerService.updateCustomer(customerName, city);
	}
	
	
	
	
	
	
	
	
	
	

}
