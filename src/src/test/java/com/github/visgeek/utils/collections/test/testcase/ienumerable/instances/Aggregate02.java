package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Aggregate02 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Action0 action = () -> source.aggregate(">", null);
		Assert2.assertNullPointerExceptionThrown("func", action);
	}

	@Test
	public void sourceIsEmpty() {
		IEnumerable<Integer> source = Enumerable.empty(Integer.class);
		String actual = source.aggregate(">", (n1, n2) -> n1 + n2);
		Assert.assertEquals(">", actual);
	}

	@Test
	public void normal() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		String actual = source.aggregate(">", (n1, n2) -> n1 + n2);
		Assert.assertEquals(">123", actual);
	}
}
