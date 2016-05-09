package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Except {
	@Test
	public void test01_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(4, 4, 3, 3, 5, 5, 6, 6);

		IEnumerable<Integer> actual = values1.except(values2);
		Assert2.assertSequanceEquals(actual, 1, 2);
	}

	@Test
	public void test02_01() {
		IEqualityComparator<Integer> comparator =
				IEqualityComparator.create(
						obj -> obj.hashCode(),
						(a, b) -> a.equals(b));

		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(4, 4, 3, 3, 5, 5, 6, 6);

		IEnumerable<Integer> actual = values1.except(values2, comparator);
		Assert2.assertSequanceEquals(actual, 1, 2);
	}
}
