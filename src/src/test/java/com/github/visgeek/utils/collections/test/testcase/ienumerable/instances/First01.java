package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class First01 {
	@Test
	public void empty() {
		IEnumerable<Integer> source = Enumerable.empty();
		Action0 action = () -> source.first();
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, action);
	}

	@Test
	public void test_first01_02() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3, 4);
		int actual = source.first();
		int expected = 1;
		Assert.assertEquals(expected, actual);
	}
}
