package com.renato.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.renato.challenge.repository.TransactionRepository;
import com.renato.challenge.service.TransactionService;

@RestController
public class ServiceRestController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionRepository transactionRepository;

	@RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public ResponseEntity<?> persistPerson(Transaction t) {
		if (transactionService.isValid(t)) {
			transactionRepository.persist(t);
			return ResponseEntity.status(201).build();
		}
		return ResponseEntity.status(204).build();
	}

	@RequestMapping(value = "/statistics", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody StatisticsResults getStatistics() {
		return transactionRepository.statistics(transactionService.lastValidTime());
	}

}