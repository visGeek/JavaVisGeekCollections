package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SumInteger {
	@Test
	public void errorArgIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Integer> selector = null;
		Action0 action = () -> source.sumInteger(selector);

		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void errorParseFailed() {
		IEnumerable<String> source = () -> Enumerable.of("1", "b", "3", "4").iterator();
		Func1<String, Integer> selector = Integer::parseInt;
		Action0 action = () -> source.sumInteger(selector);

		Assert2.assertExceptionThrown(NumberFormatException.class, action);
	}

	@Test
	public void errorOverflow() {
		IEnumerable<String> source = () -> Enumerable.of(Integer.toString(Integer.MAX_VALUE), "1").iterator();
		Func1<String, Integer> selector = Integer::parseInt;
		Action0 action = () -> source.sumInteger(selector);

		Assert2.assertExceptionThrown(ArithmeticException.class, action);
	}

	@Test
	public void successEmpty() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Integer> selector = Integer::parseInt;
		int expected = 0;

		int actual = source.sumInteger(selector);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void successNormal() {
		IEnumerable<String> source = () -> Enumerable.of("1", "2", "3", null, "4").iterator();
		Func1<String, Integer> selector = str -> str == null ? null : Integer.parseInt(str);
		int expected = 1 + 2 + 3 + 4;

		int actual = source.sumInteger(selector);
		Assert.assertEquals(expected, actual, 0);
	}
}
