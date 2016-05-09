package com.github.visgeek.utils.collections.test.testcase.ienumerable.statics;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Repeat2 {
	@Test
	public void fail() {
		Action0 action = () -> Enumerable.repeat2("a", -1);
		Assert2.assertExceptionThrown(IllegalArgumentException.class, action);
	}

	@Test
	public void countIsZero() {
		IEnumerable<String> actual = Enumerable.repeat2("a", 0);
		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void normal() {
		IEnumerable<String> actual = Enumerable.repeat2("a", 3);
		Assert2.assertSequanceEquals(actual, "a", "a", "a");
	}
}
