package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OrderByDefaultKeyDescending01 {
	@Test
	public void containsNull() {
		IEnumerable<String> source = () -> Enumerable.of("1", null, "2", null).iterator();
		IEnumerable<String> actual = source.orderByDefaultKeyDescending();
		Assert2.assertSequanceEquals(actual, "2", "1", null, null);
	}

	@Test
	public void test() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderByDefaultKeyDescending();
		Assert2.assertSequanceEquals(actual, 3, 2, 1);
	}
}
