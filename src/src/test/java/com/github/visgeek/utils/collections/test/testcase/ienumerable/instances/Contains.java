package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

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
						str -> str.length(),
						(a, b) -> Integer.parseInt(a.substring(0, 1)) == Integer.parseInt(b.substring(0, 1)));

		boolean actual = Enumerable.of("1aa", "2er", "3aaa").contains("2bb", eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains02_02() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						str -> str.length(),
						(a, b) -> Integer.parseInt(a.substring(0, 1)) == Integer.parseInt(b.substring(0, 1)));

		boolean actual = Enumerable.of("1aa", "2er", "3aaa").contains("4bbe", eComparator);
		Assert.assertFalse(actual);
	}
}
