package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Union01 {
	@Test
	public void secondIsNull() {
		IEnumerable<Integer> source = Enumerable.empty();
		IEnumerable<Integer> second = null;

		Action0 action = () -> source.union(second);
		Assert2.assertNullPointerExceptionThrown("second", action);
	}

	@Test
	public void test() {
		IEnumerable<Integer> source = () -> Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4).iterator();
		IEnumerable<Integer> second = () -> Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5).iterator();
		IEnumerable<Integer> expected = Enumerable.of(1, 2, 3, 4, 5);

		IEnumerable<Integer> actual = source.union(second);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
