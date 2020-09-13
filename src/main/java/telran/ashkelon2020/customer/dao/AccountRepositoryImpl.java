package telran.ashkelon2020.customer.dao;

import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import telran.ashkelon2020.customer.dto.DateTimeRangeDto;
import telran.ashkelon2020.customer.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public boolean existById(String accountName) {
		return em.find(Account.class, accountName) != null;
	}

	@Override
	public Optional<Account> findById(String accountName) {
		return Optional.ofNullable(em.find(Account.class, accountName));
	}

	@Override
	public Account save(Account account) {
		em.persist(account);
		return account;
	}

	@Override
	public void delete(Account account) {
		em.remove(account);
		
	}
	
	@Override
	public Stream<Account> findByAccountAndExpDate(String customerName, DateTimeRangeDto dateTimeRangeDto) {
		TypedQuery<Account> query = em.createQuery("select a from Account a join a.customer c where a.expDate between ?2 and ?3 and c.customerName = ?1", Account.class);
		query.setParameter(1, customerName);
		query.setParameter(2, dateTimeRangeDto.getFrom());
		query.setParameter(3, dateTimeRangeDto.getTo());
		return query.getResultStream();
		
	}

}
