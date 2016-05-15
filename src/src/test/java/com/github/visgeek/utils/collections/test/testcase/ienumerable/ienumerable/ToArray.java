package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;

public class ToArray {
	@Test
	public void argIsNull() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		Class<Integer> elementClass = null;
		Action0 action = () -> source.toArray(elementClass);

		Assert2.assertNullPointerExceptionThrown("elementClass", action);
	}

	@Test
	public void success() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Class<Integer> elementClass = Integer.class;
		Integer[] expected = new Integer[] { 1, 2, 3 };

		Integer[] actual = source.toArray(elementClass);
		Assert.assertArrayEquals(actual, expected);
	}
}
