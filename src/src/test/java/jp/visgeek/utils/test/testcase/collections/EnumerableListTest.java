package jp.visgeek.utils.test.testcase.collections;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.EnumerableList;
import jp.visgeek.utils.testing.Assert2;

public class EnumerableListTest {
	@Test
	public void test_ctor() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);

		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test_addAll_Collection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);

		EnumerableList<Integer> actual = new EnumerableList<>();
		actual.addAll(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test_addAll_Iterable() {
		Iterable<Integer> values = Enumerable.range(1, 3);

		EnumerableList<Integer> actual = new EnumerableList<>();
		actual.addAll(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
