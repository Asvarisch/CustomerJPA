package telran.ashkelon2020.customer.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@EqualsAndHashCode(of = { "accountName" })
@Entity
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9024493037048282647L;
	
	@Id
	String accountName;
	LocalDate expDate;
	@JsonIgnore
	@ManyToOne
	Customer customer;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	Set<Subscriber> subscribers;

	
	
	
	
	
	

}
