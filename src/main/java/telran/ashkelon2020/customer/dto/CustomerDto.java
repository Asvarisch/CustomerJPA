package telran.ashkelon2020.customer.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
	String customerName;
	String city;
	@Singular
	Set<AccountDto> accounts;

}
