package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Union {
	@Test
	public void test_union01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5);
		IEnumerable<Integer> actual = values1.union(values2);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}

	@Test
	public void test_union02() {
		IEqualityComparator<Integer> comparator = IEqualityComparator.create(a -> a);

		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5);
		IEnumerable<Integer> actual = values1.union(values2, comparator);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5);
	}
}
