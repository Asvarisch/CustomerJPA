package telran.ashkelon2020.customer.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateTimeRangeDto {
	LocalDate from;
	LocalDate to;

}
