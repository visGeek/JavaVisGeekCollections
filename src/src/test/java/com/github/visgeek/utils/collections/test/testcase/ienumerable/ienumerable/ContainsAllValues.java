package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class ContainsAllValues {
	@Test
	public void test01_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.of(2, 3, 4);

		boolean actual = values1.containsAllValues(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test01_02() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.of(2, 3, 4, 6);

		boolean actual = values1.containsAllValues(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test01_03() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.empty();

		boolean actual = values1.containsAllValues(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test01_04() {
		IEnumerable<Integer> values1 = Enumerable.empty();
		IEnumerable<Integer> values2 = Enumerable.empty();

		boolean actual = values1.containsAllValues(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test02_01() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.of("2", "3", "4");

		boolean actual = values1.containsAllValues(values2, eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test02_02() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.of("2", "3", "4", "6");

		boolean actual = values1.containsAllValues(values2, eComparator);
		Assert.assertFalse(actual);
	}

	@Test
	public void test02_03() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.empty();

		boolean actual = values1.containsAllValues(values2, eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test02_04() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.empty();
		IEnumerable<String> values2 = Enumerable.empty();

		boolean actual = values1.containsAllValues(values2, eComparator);
		Assert.assertTrue(actual);
	}
}
