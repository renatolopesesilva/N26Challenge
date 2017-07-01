package com.renato.challenge.repository;

import java.util.Calendar;

import com.renato.challenge.StatisticsResults;
import com.renato.challenge.Transaction;

public interface TransactionRepository {

	void persist(Transaction t);
	
	StatisticsResults statistics(Calendar currentTime);
}
