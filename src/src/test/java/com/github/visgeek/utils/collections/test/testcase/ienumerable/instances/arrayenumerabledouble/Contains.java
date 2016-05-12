package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.arrayenumerabledouble;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void contains() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Double target = 2.0;
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContains() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Double target = 4.0;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void argIsNull() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Double target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
