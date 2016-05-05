package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

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
		IEqualityComparator<String> cpr =
				IEqualityComparator.create(str -> str.length(), (a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<Integer> actual =
				Enumerable
						.of("01", "02", "03", "02", "01", "04", "03", "04")
						.distinct(cpr)
						.select(str -> Integer.parseInt(str));

		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4);
	}
}
