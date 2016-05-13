package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Select01 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, String> selector = null;

		Action0 action = () -> source.select(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func1<Integer, String> selector = n -> String.format("%dm", n);
		IEnumerable<String> expected = Enumerable.of("1m", "2m", "3m");

		IEnumerable<String> actual = source.select(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
