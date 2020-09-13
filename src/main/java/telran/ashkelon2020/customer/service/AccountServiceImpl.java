package telran.ashkelon2020.customer.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.customer.dao.AccountRepository;
import telran.ashkelon2020.customer.dao.CustomerRepository;
import telran.ashkelon2020.customer.dao.SubscriberRepository;
import telran.ashkelon2020.customer.dto.AccountDto;
import telran.ashkelon2020.customer.dto.DateTimeRangeDto;
import telran.ashkelon2020.customer.dto.UpdateDto;
import telran.ashkelon2020.customer.dto.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.customer.model.Account;
import telran.ashkelon2020.customer.model.Customer;

@Service
public class AccountServiceImpl implements AccountService {

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
	public boolean addAccount(String customerName, AccountDto accountDto) {
		if (accountRepository.existById(accountDto.getAccountName())) {
			return false;
		}
		Account account = modelMapper.map(accountDto, Account.class);
		Customer customer = customerRepository.findById(customerName)
				.orElseThrow(() -> new DocumentNotFoundException());
		account.setCustomer(customer);
		accountRepository.save(account);
		return true;
	}

	@Override
	public AccountDto findAccountByName(String accountName) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new DocumentNotFoundException());
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	@Transactional
	public AccountDto deleteAccount(String accountName) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new DocumentNotFoundException());
		accountRepository.delete(account);
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	@Transactional
	public AccountDto updateAccount(String accountName, UpdateDto accountUpdateDto) {
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new DocumentNotFoundException());
		account.setExpDate(accountUpdateDto.getNewExpDate().plusYears(1));
		return modelMapper.map(account, AccountDto.class);
	}

	@Override
	public Iterable<AccountDto> findByAccountAndExpDate(String customerName, DateTimeRangeDto dateTimeRangeDto) {
		return accountRepository.findByAccountAndExpDate(customerName, dateTimeRangeDto)
				.map(a -> modelMapper.map(a, AccountDto.class)).collect(Collectors.toList());
	}

}
