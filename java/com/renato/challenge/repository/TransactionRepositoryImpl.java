package com.renato.challenge.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.renato.challenge.StatisticsResults;
import com.renato.challenge.Transaction;

@Service
public class TransactionRepositoryImpl implements TransactionRepository {

	public static List<Transaction> list = new ArrayList<Transaction>();

	public synchronized void persist(final Transaction t) {
		list.add(t);
	}

	public synchronized StatisticsResults statistics(Calendar validTime) {

		final Comparator<Transaction> comp = (p1, p2) -> Double.compare(p1.getAmount(), p2.getAmount());

		List<Transaction> filteredTransactions = list.stream().filter(t -> t.getDate().after(validTime.getTime()))
				.sorted(comp).collect(Collectors.toList());

		StatisticsResults statictics = new StatisticsResults();

		statictics.setSum(filteredTransactions.stream().mapToDouble(i -> i.getAmount()).sum());
		statictics.setAvg(filteredTransactions.stream().mapToDouble(i -> i.getAmount()).average().getAsDouble());
		statictics.setMin(filteredTransactions.stream().min(comp).get().getAmount());
		statictics.setMax(filteredTransactions.stream().max(comp).get().getAmount());
		statictics.setCount(filteredTransactions.size());

		return statictics;
	}

}