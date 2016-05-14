package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Aggregate01 {
	@Test
	public void arg1IsNull() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		Action0 action = () -> source.aggregate(null);
		Assert2.assertNullPointerExceptionThrown("func", action);
	}

	@Test
	public void sourceIsEmpty() {
		IEnumerable<Integer> source = () -> Enumerable.empty(Integer.class).iterator();
		Action0 action = () -> source.aggregate((n1, n2) -> n1 + n2);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void normal() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 2, 3).iterator();
		int actual = source.aggregate((n1, n2) -> n1 + n2);
		Assert.assertEquals(6, actual);
	}
}
