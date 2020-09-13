package telran.ashkelon2020.customer.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.ashkelon2020.customer.dto.DateTimeRangeDto;
import telran.ashkelon2020.customer.model.Account;

public interface AccountRepository {
	
	boolean existById(String accountName);

	Optional<Account> findById(String accountName);

	Account save(Account account);

	void delete(Account account);

	Stream<Account> findByAccountAndExpDate(String customerName, DateTimeRangeDto dateTimeRangeDto);

	

}
