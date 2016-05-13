package com.github.visgeek.utils.collections.test.testcase.enumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Repeat {
	@Test
	public void fail() {
		Action0 action = () -> Enumerable.repeat("a", -1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void countIsZero() {
		IEnumerable<String> actual = Enumerable.repeat("a", 0);
		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void normal() {
		IEnumerable<String> actual = Enumerable.repeat("a", 3);
		Assert2.assertSequanceEquals(actual, "a", "a", "a");
	}
}
