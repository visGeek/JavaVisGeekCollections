package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SelectDouble {
	@Test
	public void argIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Double> selector = null;

		Action0 action = () -> source.selectDouble(selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void test() {
		IEnumerable<String> source = () -> Enumerable.of("1.0", "2.0", "3.0").iterator();
		Func1<String, Double> selector = str -> Double.parseDouble(str);
		IEnumerable<Double> expected = Enumerable.of(1.0, 2.0, 3.0);

		IEnumerable<Double> actual = source.selectDouble(selector);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
