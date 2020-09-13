package telran.ashkelon2020.customer.dao;

import java.util.Optional;
import java.util.stream.Stream;

import telran.ashkelon2020.customer.model.Subscriber;

public interface SubscriberRepository {

	boolean existById(String subscriberName);

	Subscriber save(Subscriber subscriber);

	Optional<Subscriber> findById(String subscriberName);

	void delete(Subscriber subscriber);
	
	Stream<Subscriber> findByFirstLetter(String firstLetter);

}
