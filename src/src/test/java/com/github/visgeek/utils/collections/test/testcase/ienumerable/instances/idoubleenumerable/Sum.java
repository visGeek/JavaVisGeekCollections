package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.idoubleenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class Sum {
	@Test
	public void test() {
		IDoubleEnumerable source = Enumerable.of(null, 1.0, 2.0, 3.0).selectDouble(n -> n);
		double expected = 1 + 2 + 3;

		double actual = source.sum();
		Assert.assertEquals(expected, actual, 0);
	}
}
