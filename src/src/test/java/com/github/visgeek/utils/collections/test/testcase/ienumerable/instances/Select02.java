package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Select02 {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func2<Integer, Integer, String> selector = null;

		Action0 action = () -> source.select(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Func2<Integer, Integer, String> selector = (n, index) -> String.format("%d:%dm", index, n);
		IEnumerable<String> expected = Enumerable.of("0:1m", "1:2m", "2:3m");

		IEnumerable<String> actual = source.select(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
