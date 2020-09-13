package telran.ashkelon2020.customer.conntroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.customer.dto.SubscriberDto;
import telran.ashkelon2020.customer.dto.UpdateDto;
import telran.ashkelon2020.customer.service.SubscriberService;

@RestController
public class SubscriberController {
	
	@Autowired
	SubscriberService subscriberService; 

	@PostMapping("/subscriber/account/{accountName}")
	public boolean addSubscriber(@PathVariable String accountName, @RequestBody SubscriberDto subscriberDto) {
		return subscriberService.addSubscriber(accountName, subscriberDto);
	}

	@GetMapping("/subscriber/{subscriberName}")
	public SubscriberDto findSubscriber(@PathVariable String subscriberName) {
		return subscriberService.findSubscriberByName(subscriberName);
	}

	@DeleteMapping("/subscriber/{subscriberName}")
	public SubscriberDto deleteSubscriber(@PathVariable String subscriberName) {
		return subscriberService.deleteSubscriber(subscriberName);
	}

	@PutMapping("/subscriber/{subscriberName}")
	public SubscriberDto updateSubscriber(@PathVariable String subscriberName, @RequestBody UpdateDto subscriberUpdateDto) {
		return subscriberService.updateSubscriber(subscriberName, subscriberUpdateDto);
	}

	@GetMapping("/subscribers/letter/{firstLetter}")
	public Iterable<SubscriberDto> findByFirstLetter(@PathVariable String firstLetter) {
		return subscriberService.findByFirstLetter(firstLetter);
	}

}
