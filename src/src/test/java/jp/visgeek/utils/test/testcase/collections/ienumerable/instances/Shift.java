package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Shift {
	@Test
	public void test_shift01_01() {
		IEnumerable<Integer> actual = Enumerable.empty(Integer.class).shift(1);
		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test_shift01_02() {
		IEnumerable<Integer> actual = Enumerable.range(0, 4).toList().shift(0);
		Assert2.assertSequanceEquals(actual, 0, 1, 2, 3);
	}

	@Test
	public void test_shift02_01() {
		IEnumerable<Integer> actual = Enumerable.range(0, 4).toList().shift(1);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 0);
	}

	@Test
	public void test_shift02_02() {
		IEnumerable<Integer> actual = Enumerable.range(0, 4).toList().shift(5);
		Assert2.assertSequanceEquals(actual, 1, 2, 3, 0);
	}

	@Test
	public void test_shift03_01() {
		IEnumerable<Integer> actual = Enumerable.range(0, 4).toList().shift(-1);
		Assert2.assertSequanceEquals(actual, 3, 0, 1, 2);
	}

	@Test
	public void test_shift03_02() {
		IEnumerable<Integer> actual = Enumerable.range(0, 4).toList().shift(-5);
		Assert2.assertSequanceEquals(actual, 3, 0, 1, 2);
	}
}
