package telran.ashkelon2020.customer.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.DateTimeRangeDto;
import telran.ashkelon2020.customer.dto.UpdateDto;
import telran.ashkelon2020.customer.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/account/customer/{customerName}")
	public boolean addAccount(@PathVariable String customerName, @RequestBody AccountDto accountDto) {
		return accountService.addAccount(customerName, accountDto);
	}

	@GetMapping("/account/{accountName}")
	public AccountDto findAccount(@PathVariable String accountName) {
		return accountService.findAccountByName(accountName);
	}

	@DeleteMapping("/account/{accountName}")
	public AccountDto deleteAccount(@PathVariable String accountName) {
		return accountService.deleteAccount(accountName);
	}

	@PutMapping("/account/{accountName}")
	public AccountDto updateAccount(@PathVariable String accountName, @RequestBody UpdateDto accountUpdateDto) {
		return accountService.updateAccount(accountName, accountUpdateDto);
	}

	@PostMapping("/accounts/customer/{customerName}")
	public Iterable<AccountDto> findByAccountAndExpDate(@PathVariable String customerName, @RequestBody DateTimeRangeDto dateTimeRangeDto) {
		return accountService.findByAccountAndExpDate(customerName, dateTimeRangeDto);
	}

}
