package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class Intersect {
	@Test
	public void test01_argIsNull() {
		Action0 action = () -> Enumerable.empty().intersect(null);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void test01_normal() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5);
		IEnumerable<Integer> actual = values1.intersect(values2);
		Assert2.assertSequanceEquals(actual, 2, 3, 4);
	}

	@Test
	public void test02_arg1IsNull() {
		Action0 action = () -> Enumerable.empty().intersect(null);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void test02_normal() {
		IEqualityComparator<String> comparator = IEqualityComparator.create(str -> str.substring(1));

		IEnumerable<String> values1 = Enumerable.of("a1", "a1", "a2", "a2", "a3", "a3", "a4", "a4");
		IEnumerable<String> values2 = Enumerable.of("b3", "b3", "b2", "b2", "b4", "b4", "b5", "b5");

		IEnumerable<String> actual = values1.intersect(values2, comparator);
		Assert2.assertSequanceEquals(actual, "a2", "a3", "a4");
	}
}
