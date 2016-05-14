package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Last01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.of(Arrays.asList());
		Action0 action = () -> source.last();
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void any() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3, 4);
		int actual = source.last();
		int expected = 4;
		Assert.assertEquals(expected, actual);
	}
}
