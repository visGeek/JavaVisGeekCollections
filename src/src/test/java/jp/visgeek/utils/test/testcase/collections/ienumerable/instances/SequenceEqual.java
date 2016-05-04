package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;

public class SequenceEqual {
	@Test
	public void test_sequenceEqual01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4);
		IEnumerable<Integer> values2 = Enumerable.of(1, 2, 3, 4);
		boolean actual = values1.sequenceEqual(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_sequenceEqual02() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> values2 = Enumerable.of(1, 2, 3, 4);
		boolean actual = values1.sequenceEqual(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_sequenceEqual03() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4);
		IEnumerable<Integer> values2 = Enumerable.of(1, 2, 3);
		boolean actual = values1.sequenceEqual(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_sequenceEqual04() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3);
		IEnumerable<Integer> values2 = Enumerable.of(1, 2, 4);
		boolean actual = values1.sequenceEqual(values2);
		Assert.assertFalse(actual);
	}
}
