package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.IEqualityComparator;
import jp.visgeek.utils.JoinedValue;
import jp.visgeek.utils.collections.Enumerable;

public class Join {
	@Test
	public void test_join01_01() {
		List<JoinedValue<Integer, Integer>> actual =
				Enumerable
						.of(1, 2, 3)
						.join(Enumerable.of(1, 1, 2, 3), n -> n, n -> n)
						.toList();

		Assert.assertEquals(4, actual.size());
		Assert.assertTrue(actual.get(0).equals(1, 1));
		Assert.assertTrue(actual.get(1).equals(1, 1));
		Assert.assertTrue(actual.get(2).equals(2, 2));
		Assert.assertTrue(actual.get(3).equals(3, 3));
	}

	@Test
	public void test_join02_01() {
		List<Integer> actual =
				Enumerable
						.of(1, 2, 3)
						.join(Enumerable.of(1, 1, 2, 3), n -> n, n -> n, (n1, n2) -> n1)
						.toList();

		Assert.assertEquals(4, actual.size());
		Assert.assertTrue(actual.get(0).equals(1));
		Assert.assertTrue(actual.get(1).equals(1));
		Assert.assertTrue(actual.get(2).equals(2));
		Assert.assertTrue(actual.get(3).equals(3));
	}

	@Test
	public void test_join04_01() {
		IEqualityComparator<Integer> comparator = IEqualityComparator.create(n -> n);

		List<Integer> actual =
				Enumerable
						.of(1, 2, 3)
						.join(Enumerable.of(1, 1, 2, 3), n -> n, n -> n, (n1, n2) -> n1, comparator)
						.toList();

		Assert.assertEquals(4, actual.size());
		Assert.assertTrue(actual.get(0).equals(1));
		Assert.assertTrue(actual.get(1).equals(1));
		Assert.assertTrue(actual.get(2).equals(2));
		Assert.assertTrue(actual.get(3).equals(3));
	}
}
