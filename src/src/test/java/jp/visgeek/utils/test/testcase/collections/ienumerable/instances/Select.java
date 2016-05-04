package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;

public class Select {
	@Test
	public void test_select01() {
		IEnumerable<String> actual =
				Enumerable
						.of(1, 2, 3)
						.select(n -> String.format("%dm", n));

		Assert2.assertSequanceEquals(actual, "1m", "2m", "3m");
	}

	@Test
	public void test_select02() {
		IEnumerable<String> actual =
				Enumerable
						.of(1, 2, 3)
						.select((n, index) -> String.format("%d:%dm", index, n));

		Assert2.assertSequanceEquals(actual, "0:1m", "1:2m", "2:3m");
	}
}
