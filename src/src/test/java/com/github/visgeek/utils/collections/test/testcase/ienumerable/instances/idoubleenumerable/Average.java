package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.idoubleenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;

public class Average {
	@Test
	public void test() {
		IDoubleEnumerable source = Enumerable.of(null, 1.0, 2.0, 3.0).selectDouble(n -> n);
		Double expected = (1.0 + 2.0 + 3.0) / 3;

		Double actual = source.average();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		IDoubleEnumerable source = Enumerable.of(new Double[] {}).selectDouble(n -> n);
		Double expected = null;

		Double actual = source.average();
		Assert.assertEquals(expected, actual);
	}
}
