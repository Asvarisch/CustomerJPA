package telran.ashkelon2020.customer.dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import telran.ashkelon2020.customer.model.Customer;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
	String accountName;
	LocalDate expDate;
	Customer customer;
	@Singular
	Set<SubscriberDto> subscribers;

}
