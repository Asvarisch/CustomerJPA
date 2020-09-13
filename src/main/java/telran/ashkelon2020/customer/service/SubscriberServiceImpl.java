package telran.ashkelon2020.customer.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.customer.dao.AccountRepository;
import telran.ashkelon2020.customer.dao.CustomerRepository;
import telran.ashkelon2020.customer.dao.SubscriberRepository;
import telran.ashkelon2020.customer.dto.SubscriberDto;
import telran.ashkelon2020.customer.dto.UpdateDto;
import telran.ashkelon2020.customer.dto.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.customer.model.Account;
import telran.ashkelon2020.customer.model.Subscriber;

@Service
public class SubscriberServiceImpl implements SubscriberService {
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
	public boolean addSubscriber(String accountName, SubscriberDto subscriberDto) {
		if (subscriberRepository.existById(subscriberDto.getSubscriberName())) {
			return false;
		}
		Account account = accountRepository.findById(accountName).orElseThrow(() -> new DocumentNotFoundException());
		Subscriber subscriber = modelMapper.map(subscriberDto, Subscriber.class);
		subscriber.setAccount(account);
		subscriberRepository.save(subscriber);
		return true;
	}

	@Override
	public SubscriberDto findSubscriberByName(String subscriberName) {
		Subscriber subscriber = subscriberRepository.findById(subscriberName).orElseThrow(() -> new DocumentNotFoundException());
		return modelMapper.map(subscriber, SubscriberDto.class);
	}

	@Override
	@Transactional
	public SubscriberDto deleteSubscriber(String subscriberName) {
		Subscriber subscriber = subscriberRepository.findById(subscriberName).orElseThrow(() -> new DocumentNotFoundException());
		subscriberRepository.delete(subscriber);
		return modelMapper.map(subscriber, SubscriberDto.class);
	}

	@Override
	@Transactional
	public SubscriberDto updateSubscriber(String subscriberName, UpdateDto subscriberUpdateDto) {
		Subscriber subscriber = subscriberRepository.findById(subscriberName).orElseThrow(() -> new DocumentNotFoundException());
		subscriber.setExpDate(subscriberUpdateDto.getNewExpDate().plusYears(1));
		return modelMapper.map(subscriber, SubscriberDto.class);
	}

	@Override
	public Iterable<SubscriberDto> findByFirstLetter(String firstLetter) {
		return subscriberRepository.findByFirstLetter(firstLetter)
				.map(s -> modelMapper.map(s, SubscriberDto.class))
				.collect(Collectors.toList());
	}

}
