package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;

public class ToArray {
	@Test
	public void test_toArray01() {
		Integer[] actual = Enumerable.of(1, 2, 3).toArray(Integer.class);
		Assert.assertArrayEquals(actual, new Integer[] { 1, 2, 3 });
	}

	@Test
	public void test_toArray02() {
		double[] actual = Enumerable.ofDouble(1.0, 2.0, 3.0).toArray();
		Assert.assertArrayEquals(actual, new double[] { 1.0, 2.0, 3.0 }, 0);
	}

	@Test
	public void test_toArray03() {
		int[] actual = Enumerable.ofInteger(1, 2, 3).toArray();
		Assert.assertArrayEquals(actual, new int[] { 1, 2, 3 });
	}

	@Test
	public void test_toArray04() {
		long[] actual = Enumerable.ofLong(1L, 2L, 3L).toArray();
		Assert.assertArrayEquals(actual, new long[] { 1L, 2L, 3L });
	}
}
