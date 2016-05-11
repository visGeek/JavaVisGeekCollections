package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.ilongenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;

public class Average {
	@Test
	public void test() {
		ILongEnumerable source = Enumerable.of(null, 1L, 2L, 3L).selectLong(n -> n);
		Double expected = (double) (1L + 2L + 3L) / 3;

		Double actual = source.average();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		ILongEnumerable source = Enumerable.of(new Long[] {}).selectLong(n -> n);
		Double expected = null;

		Double actual = source.average();
		Assert.assertEquals(expected, actual);
	}
}
