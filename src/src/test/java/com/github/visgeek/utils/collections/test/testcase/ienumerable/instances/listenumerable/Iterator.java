package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.listenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		Integer[] expected = new Integer[] { 1, 2, 3 };

		Assert2.assertSequanceEquals(source, expected);
	}
}
