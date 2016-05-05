package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	private final IEqualityComparator<String> eComparator =
			IEqualityComparator.create(
					str -> {System.out.println(str);   return str.length(); },
					(a, b) -> Integer.parseInt(a.substring(0, 1)) == Integer.parseInt(b.substring(0, 1)));

	@Test
	public void test_contains01_01() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		boolean actual = values.contains(2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains01_02() {
		IEnumerable<Integer> values = Enumerable.of(1, 2, 3);
		boolean actual = values.contains(4);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_contains01_03() {
		Collection<Integer> values = Enumerable.of(1, 2, 3).toList();
		boolean actual = values.contains(2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains01_04() {
		Collection<Integer> values = Enumerable.of(1, 2, 3).toList();
		boolean actual = values.contains(4);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_contains02_01() {
		boolean actual = Enumerable.of("1aa", "2er", "3aaa").contains("2bb", this.eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_contains02_02() {
		boolean actual = Enumerable.of("1aa", "2er", "3aaa").contains("4bbe", this.eComparator);
		Assert.assertFalse(actual);
	}
}
