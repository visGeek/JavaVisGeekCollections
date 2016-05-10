package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SelectInteger {
	@Test
	public void argIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Integer> selector = null;

		Action0 action = () -> source.selectInteger(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of("1", "2", "3").iterator();
		Func1<String, Integer> selector = str -> Integer.parseInt(str);
		IEnumerable<Integer> expected = Enumerable.of(1, 2, 3);

		IEnumerable<Integer> actual = source.selectInteger(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
