package com.github.visgeek.utils.collections.test.testcase.arrayenumerabledouble;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void testSuccess() {
		IEnumerable<Double> source = Enumerable.of( 1.0, 2.0, 3.0 );
		int expected = 3;

		int actual = source.count();
		Assert.assertEquals(expected, actual);
	}
}
