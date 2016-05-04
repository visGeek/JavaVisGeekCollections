package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import java.util.List;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.testing.Assert2;

public class ToList {
	@Test
	public void test_toList01() {
		List<Integer> actual = Enumerable.of(1, 2, 3).toList();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}
}
