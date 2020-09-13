package telran.ashkelon2020.customer.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.ashkelon2020.customer.model.Account;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriberDto {
	String subscriberName;
	LocalDate expDate;
	Account account;

}
