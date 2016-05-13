package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import java.util.function.Predicate;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Where01 {
	@Test
	public void predicateIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Predicate<Integer> predicate = null;
		Action0 action = () -> source.where(predicate);

		Assert2.assertNullPointerExceptionThrown("predicate", action);
	}

	@Test
	public void test() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Predicate<Integer> predicate = n -> 2 <= n;
		Integer[] expected = new Integer[] { 2, 3 };

		IEnumerable<Integer> actual = source.where(predicate);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
