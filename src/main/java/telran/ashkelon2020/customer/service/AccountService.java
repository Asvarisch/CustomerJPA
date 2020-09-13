package telran.ashkelon2020.customer.service;

import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.DateTimeRangeDto;
import telran.ashkelon2020.customer.dto.UpdateDto;

public interface AccountService {
	
	boolean addAccount(String customerName, AccountDto accountDto);

	AccountDto findAccountByName(String accountName);

	AccountDto deleteAccount(String accountName);

	AccountDto updateAccount(String accountName, UpdateDto accountUpdateDto);
	
	Iterable<AccountDto> findByAccountAndExpDate(String customerName, DateTimeRangeDto dateTimeRangeDto);

}
