package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SumFloat {
	@Test
	public void errorArgIsNull() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Float> selector = null;
		Action0 action = () -> source.sumFloat(selector);

		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void errorParseFailed() {
		IEnumerable<String> source = () -> Enumerable.of("1.0", "b", "3.0", "4.0").iterator();
		Func1<String, Float> selector = Float::parseFloat;
		Action0 action = () -> source.sumFloat(selector);

		Assert2.assertExceptionThrown(NumberFormatException.class, action);
	}

	@Test
	public void successNoOverflow() {
		IEnumerable<String> source = () -> Enumerable.of(Float.toString(Float.MAX_VALUE), "1.0").iterator();
		Func1<String, Float> selector = Float::parseFloat;
		Action0 action = () -> source.sumFloat(selector);

		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void successEmpty() {
		IEnumerable<String> source = () -> Enumerable.empty(String.class).iterator();
		Func1<String, Float> selector = Float::parseFloat;
		double expected = 0;

		double actual = source.sumFloat(selector);
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void successNormal() {
		IEnumerable<String> source = () -> Enumerable.of("1.0", "2.0", "3.0", null, "4.0").iterator();
		Func1<String, Float> selector = str -> str == null ? null : Float.parseFloat(str);
		double expected = 1.0 + 2.0 + 3.0 + 4.0;

		double actual = source.sumFloat(selector);
		Assert.assertEquals(expected, actual, 0);
	}
}
