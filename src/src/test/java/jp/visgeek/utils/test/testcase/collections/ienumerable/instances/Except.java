package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.IEqualityComparator;
import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Except {
	@Test
	public void test_except01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(4, 4, 3, 3, 5, 5, 6, 6);

		IEnumerable<Integer> actual = values1.except(values2);
		Assert2.assertSequanceEquals(actual, 1, 2);
	}

	@Test
	public void test_except02() {
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