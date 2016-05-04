package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;

public class Empty {
	@Test
	public void test_empty01() {
		Assert.assertTrue(Enumerable.empty(Integer.class).toList().isEmpty());
	}
}
