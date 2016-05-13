package com.github.visgeek.utils.collections.test.testcase.iintegerenumerable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class Sum {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		IIntegerEnumerable source = Enumerable.of(null, 1, 2, 3).selectInteger(n -> n);
		int expected = 1 + 2 + 3;

		int actual = source.sum();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void orverflow() {
		this.expectedException.expect(ArithmeticException.class);
		IIntegerEnumerable source = Enumerable.of(Integer.MAX_VALUE, 1).selectInteger(n -> n);
		source.sum();
	}
}
