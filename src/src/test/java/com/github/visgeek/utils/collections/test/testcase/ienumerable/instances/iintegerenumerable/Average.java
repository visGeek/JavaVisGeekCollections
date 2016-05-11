package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.iintegerenumerable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class Average {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		IIntegerEnumerable source = Enumerable.of(null, 1, 2, 3).selectInteger(n -> n);
		Double expected = (double) (1 + 2 + 3) / 3;

		Double actual = source.average();
		Assert.assertEquals(expected, actual, 0);
	}

	@Test
	public void empty() {
		IIntegerEnumerable source = Enumerable.of(new Integer[] {}).selectInteger(n -> n);
		Double expected = null;

		Double actual = source.average();
		Assert.assertEquals(expected, actual);
	}
}
