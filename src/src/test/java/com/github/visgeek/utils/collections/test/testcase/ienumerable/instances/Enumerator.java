package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IEnumerator;
import com.github.visgeek.utils.testing.Assert2;

public class Enumerator {
	@Test
	public void enumerator() {
		IEnumerator<Integer> e = Enumerable.range(0, 3).enumerator();
		IEnumerable<Integer> actual = e.toEnumerableRemaining();
		Assert2.assertSequanceEquals(actual, 0, 1, 2);
	}
}
