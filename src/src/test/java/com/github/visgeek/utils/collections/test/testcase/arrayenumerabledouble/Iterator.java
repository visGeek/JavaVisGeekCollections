package com.github.visgeek.utils.collections.test.testcase.arrayenumerabledouble;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		Assert2.assertSequanceEquals(source, 1.0, 2.0, 3.0);
	}
}
