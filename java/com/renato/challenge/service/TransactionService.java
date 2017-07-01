package com.renato.challenge.service;

import java.util.Calendar;

import com.renato.challenge.Transaction;

public interface TransactionService {

	boolean isValid(Transaction t);
	
	Calendar lastValidTime();
}
