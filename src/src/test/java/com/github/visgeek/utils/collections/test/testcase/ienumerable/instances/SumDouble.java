package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SumDouble {
	@Test
	public void errorArgIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Double> selector = null;
		Action0 action = () -> source.sumDouble(selector);

		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void errorParseFailed() {
		IEnumerable<String> source = () -> Enumerable.of("1.0", "b", "3.0", "4.0").iterator();
		Func1<String, Double> selector = Double::parseDouble;
		Action0 action = () -> source.sumDouble(selector);

		Assert2.assertExceptionThrown(NumberFormatException.class, action);
	}

	@Test
	public void successNoOverflow() {
		IEnumerable<String> source = () -> Enumerable.of(Double.toString(Double.MAX_VALUE), "1.0").iterator();
		Func1<String, Double> selector = Double::parseDouble;
		Action0 action = () -> source.sumDouble(selector);

		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void successEmpty() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Double> selector = Double::parseDouble;
		double expected = 0;

		double actual = source.sumDouble(selector);
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void successNormal() {
		IEnumerable<String> source = () -> Enumerable.of("1.0", "2.0", "3.0", null, "4.0").iterator();
		Func1<String, Double> selector = str -> str == null ? null : Double.parseDouble(str);
		double expected = 1.0 + 2.0 + 3.0 + 4.0;

		double actual = source.sumDouble(selector);
		Assert.assertEquals(expected, actual, 0);
	}
}
