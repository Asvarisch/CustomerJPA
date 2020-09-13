package telran.ashkelon2020.customer.dao;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.customer.model.Subscriber;

@Repository
public class SubscriberRepositoryImpl implements SubscriberRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean existById(String subscriberName) {
		return em.find(Subscriber.class, subscriberName) != null;
	}

	@Override
	public Subscriber save(Subscriber subscriber) {
		em.persist(subscriber);
		return subscriber;
	}

	@Override
	public Optional<Subscriber> findById(String subscriberName) {
		return Optional.ofNullable(em.find(Subscriber.class, subscriberName));
	}

	@Override
	public void delete(Subscriber subscriber) {
		em.remove(subscriber);
		
	}

	@Override
	public Stream<Subscriber> findByFirstLetter(String firstLetter) {
		String letter = firstLetter+"%";
		System.out.println(letter);
		TypedQuery<Subscriber> query = em.createQuery("select s from Subscriber s where s.subscriberName LIKE ?1", Subscriber.class);
		query.setParameter(1, letter);
		return query.getResultStream();
	}

}
