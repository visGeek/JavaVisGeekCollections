package com.github.visgeek.utils.collections.test.testcase.enumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class Range2 {
	@Test
	public void argErrorCountIsNegative() {
		Action0 action = () -> Enumerable.range2(0, -1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void argErrorOverIntegerMax() {
		Action0 action = () -> Enumerable.range2(Integer.MAX_VALUE, 2);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void startIsNegative() {
		IEnumerable<Integer> actual = Enumerable.range2(-3, 3);
		Assert2.assertSequanceEquals(actual, -3, -2, -1);
	}

	@Test
	public void startIsZero() {
		IEnumerable<Integer> actual = Enumerable.range2(0, 3);
		Assert2.assertSequanceEquals(actual, 0, 1, 2);
	}

	@Test
	public void startIsPositive() {
		IEnumerable<Integer> actual = Enumerable.range2(3, 3);
		Assert2.assertSequanceEquals(actual, 3, 4, 5);
	}

	@Test
	public void countIsZero() {
		IEnumerable<Integer> actual = Enumerable.range2(1, 0);
		Assert2.assertSequanceEquals(actual);
	}
}
