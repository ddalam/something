package com.example.Something.stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class TransactionTest {

	public List<Transaction> getTransactions() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		final List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);

		return transactions;
	}

	@Test
	void 테스트1_2011년에_일어난_모든_트랜잭션을_찾아_값을_오름차순으로_정리() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		List<Transaction> collect = transactions.stream()
				.filter(transaction -> transaction.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.collect(toList());

		// then
		final List<Integer> value = collect.stream()
				.map(Transaction::getValue)
				.collect(toList());

		assertThat(value).containsExactly(300, 400);
	}

	@Test
	void 거래자가_근무하는_모든_도시를_중복_없이_나열() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		final List<String> city = transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())
				.distinct()
				.collect(toList());

		// then
	  assertThat(city).contains("Cambridge", "Milan");
	}

	@Test
	void 케임브리지에서_근무하는_모든_거래자를_찾아서_이름순으로_정렬() {
	  // given
	  List<Transaction> transactions = getTransactions();

	  // when
		List<String> names = transactions.stream()
				.map(Transaction::getTrader)
				.filter(trader -> trader.getCity().equals("Cambridge"))
				.distinct()
				.sorted(comparing(Trader::getName))
				.map(Trader::getName)
				.collect(toList());

		// then
		assertThat(names).containsExactly("Alan", "Brian", "Raoul");
	}

	@Test
	void 모든_거래자의_이름을_알파벳순으로_정렬해서_반환() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		String name = transactions.stream()
				.map(transaction -> transaction.getTrader().getName())
				.distinct()
				.sorted()
				.reduce("", (n1, n2) -> n1 + n2);

		// then
		assertThat(name).isEqualTo("AlanBrianMarioRaoul");
	}

	@Test
	void 밀라노에_거래자가_있는가() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		boolean milanBased = transactions.stream()
				.anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

		// then
	  assertThat(milanBased).isTrue();
	}

	@Test
	void 케임브리지에_거주하는_거래자의_모든_트랜잭션_값을_출력() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // then
		transactions.stream()
				.filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
				.map(Transaction::getValue)
				.forEach(System.out::println);
	}

	@Test
	void 전체_트랜잭션_중_최댓값() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		Optional<Integer> highestValue = transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max);

		// then
		assertThat(highestValue).hasValue(1000);
	}

	@Test
	void 전체_트랜잭션_중_최솟값() {
	  // given
		List<Transaction> transactions = getTransactions();

	  // when
		Optional<Transaction> smallestTransaction = transactions.stream()
				.min(comparing(Transaction::getValue));

		// then
		assertThat(smallestTransaction.get().getValue()).isEqualTo(300);
	}
}
