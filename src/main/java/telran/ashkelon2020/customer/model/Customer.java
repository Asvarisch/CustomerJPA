package telran.ashkelon2020.customer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"customerName"})
@Entity
public class Customer  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8240836093581590170L;
	
	@Id
	String customerName;
	String city;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	Set<Account> accounts;
	
	
	
	

}
