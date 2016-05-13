package com.github.visgeek.utils.collections.test.testcase.ilongenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;

public class Sum {
	@Test
	public void test() {
		ILongEnumerable source = Enumerable.of(null, 1L, 2L, 3L).selectLong(n -> n);
		long expected = 1 + 2 + 3;

		long actual = source.sum();
		Assert.assertEquals(expected, actual, 0);
	}
}
