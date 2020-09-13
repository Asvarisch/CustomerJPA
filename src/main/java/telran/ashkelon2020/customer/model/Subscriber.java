package telran.ashkelon2020.customer.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "subscriberName" })
@Entity
public class Subscriber implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5066221444231261970L;
	@Id
	String subscriberName;
	LocalDate expDate;
	@JsonIgnore
	@ManyToOne
	Account account;
	
	
	

}
