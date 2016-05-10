package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ToString02 {
	@Test
	public void selectorIsNull() {
		IEnumerable<Integer> source = Enumerable.empty();
		String separator = "";
		Func1<Integer, Object> selector = null;

		Action0 action = () -> source.toString(separator, selector);
		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		String separator = "";
		Func1<Integer, Object> selector = n -> n + "m";
		String expected = "";

		String actual = source.toString(separator, selector);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void separatorIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, null, 3, 4).iterator();
		String separator = null;
		Func1<Integer, Object> selector = n -> n == null ? null : n + "m";
		String expected = "1m2m3m4m";

		String actual = source.toString(separator, selector);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nomal() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, null, 3, 4).iterator();
		String separator = ", ";
		Func1<Integer, Object> selector = n -> n == null ? null : n + "m";
		String expected = "1m, 2m, , 3m, 4m";

		String actual = source.toString(separator, selector);
		Assert.assertEquals(expected, actual);
	}
}
