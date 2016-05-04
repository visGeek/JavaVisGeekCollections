package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class Aggregate {
	@Test
	public void test_aggregate01_01() {
		int actual = Enumerable.of(1, 2, 3).aggregate((n1, n2) -> n1 + n2);
		Assert.assertEquals(6, actual);
	}

	@Test
	public void test_aggregate01_02() {
		try {
			Enumerable.empty(Integer.class).aggregate((n1, n2) -> n1 + n2);
			Assert.fail();
		} catch (Exception e) {
			//
		}
	}

	@Test
	public void test_aggregate02_01() {
		String actual =
				Enumerable.of(1, 2, 3)
						.aggregate(">", (n1, n2) -> n1 + n2);

		Assert.assertEquals(actual, ">123");
	}

	@Test
	public void test_aggregate02_02() {
		String actual =
				Enumerable.of(1, 2, 3)
						.aggregate(">", (n1, n2) -> n1 + n2, n -> String.format("[%s]", n));

		Assert.assertEquals(actual, "[>123]");
	}
}
