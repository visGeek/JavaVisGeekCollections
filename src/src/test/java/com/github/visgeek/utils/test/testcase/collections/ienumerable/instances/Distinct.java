package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Distinct {
	@Test
	public void test_distinct01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 2, 1, 4, 3, 4).distinct();
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4);
	}

	@Test
	public void test_distinct02() {
		IEqualityComparator<Integer> cpr =
				IEqualityComparator.create(
						obj -> new Integer(obj % 2).hashCode(),
						(a, b) -> a % 2 == b % 2);

		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3, 2, 1, 4, 3, 4).distinct(cpr);
		Assert2.assertSequanceEquals(actual, 1, 2);
	}
}
