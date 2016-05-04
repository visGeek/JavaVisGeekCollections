package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.IEqualityComparator;
import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Intersect {
	public void test_intersect01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5);
		IEnumerable<Integer> actual = values1.intersect(values2);
		Assert2.assertSequanceEquals(actual, 2, 3, 4);
	}

	@Test
	public void test_intersect02() {
		IEqualityComparator<Integer> comparator = IEqualityComparator.create(obj -> obj);

		IEnumerable<Integer> values1 = Enumerable.of(1, 1, 2, 2, 3, 3, 4, 4);
		IEnumerable<Integer> values2 = Enumerable.of(3, 3, 2, 2, 4, 4, 5, 5);

		IEnumerable<Integer> actual = values1.intersect(values2, comparator);
		Assert2.assertSequanceEquals(actual, 2, 3, 4);
	}
}
