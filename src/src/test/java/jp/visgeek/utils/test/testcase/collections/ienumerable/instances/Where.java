package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Where {
	@Test
	public void test_where01_01() {
		IEnumerable<Integer> actual = Enumerable.of(1, 2, 3).where(n -> 2 <= n);
		Assert2.assertSequanceEquals(actual, 2, 3);
	}

	@Test
	public void test_whereIndex01_01() {
		IEnumerable<Integer> actual = Enumerable.of(0, 2, 2, 3).where((n, idx) -> n <= idx);
		Assert2.assertSequanceEquals(actual, 0, 2, 3);
	}
}
