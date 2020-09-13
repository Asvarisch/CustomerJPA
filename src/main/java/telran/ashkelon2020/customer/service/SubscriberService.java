package telran.ashkelon2020.customer.service;

import telran.ashkelon2020.customer.dto.SubscriberDto;
import telran.ashkelon2020.customer.dto.UpdateDto;


public interface SubscriberService {

	boolean addSubscriber(String accountName, SubscriberDto subscriberDto);

	SubscriberDto findSubscriberByName(String subscriberName);

	SubscriberDto deleteSubscriber(String subscriberName);

	SubscriberDto updateSubscriber(String subscriberName, UpdateDto subscriberUpdateDto);

	Iterable<SubscriberDto> findByFirstLetter(String firstLetter);

}
