package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class ThenByDefaultKey01 {
	@Test
	public void containsNull() {
		IEnumerable<String> source = () -> Enumerable.of("1", null, "2", null).iterator();
		IEnumerable<String> actual = source.orderBy((a, b) -> 0).thenByDefaultKey();
		Assert2.assertSequanceEquals(actual, null, null, "1", "2");
	}

	@Test
	public void test() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderBy((a, b) -> 0).thenByDefaultKey();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
