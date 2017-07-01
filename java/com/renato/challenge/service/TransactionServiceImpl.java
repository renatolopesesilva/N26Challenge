package com.renato.challenge.service;

import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.renato.challenge.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	public boolean isValid(Transaction t) {

		Calendar calendar = lastValidTime();
		
		if (t.getDate().after(calendar.getTime())) {
			return true;
		}
		return false;
	}

	public Calendar lastValidTime() {
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		calendar.add(Calendar.SECOND, -60);
		return calendar;
	}

}