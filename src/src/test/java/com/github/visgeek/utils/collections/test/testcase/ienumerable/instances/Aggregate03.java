package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Aggregate03 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.<Integer, Integer> aggregate(null, null, n -> n);
		Assert2.assertNullPointerExceptionThrown("func", action);
	}

	@Test
	public void arg2IsNull() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.<Integer, Integer> aggregate(null, (n1, n2) -> n1 + n2, null);
		Assert2.assertNullPointerExceptionThrown("resultSelector", action);
	}

	@Test
	public void sourceIsEmpty() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		String actual = source.aggregate(">", (n1, n2) -> n1 + n2, n -> String.format("[%s]", n));
		Assert.assertEquals("[>]", actual);
	}

	@Test
	public void normal() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		String actual = source.aggregate(">", (n1, n2) -> n1 + n2, n -> String.format("[%s]", n));
		Assert.assertEquals(actual, "[>123]");
	}
}
