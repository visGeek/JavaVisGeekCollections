package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;

public class Contains {
	@Test
	public void test_contains01_01() {
		boolean actual = Enumerable.of(1, 2, 3).contains(2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains01_02() {
		boolean actual = Enumerable.of(1, 2, 3).contains(4);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_contains02_01() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		boolean actual = Enumerable.of("01", "02", "03").contains("2", eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains02_02() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		boolean actual = Enumerable.of("01", "02", "03").contains("4", eComparator);
		Assert.assertFalse(actual);
	}
}
