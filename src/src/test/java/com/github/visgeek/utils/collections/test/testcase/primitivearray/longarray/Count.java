package com.github.visgeek.utils.collections.test.testcase.primitivearray.longarray;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void testSuccess() {
		IEnumerable<Long> source = Enumerable.of(1L, 2L, 3L);
		int expected = 3;

		int actual = source.count();
		Assert.assertEquals(expected, actual);
	}
}
