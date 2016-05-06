package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Aggregate {
	@Test
	public void test01_01() {
		Assert2.exceptionThrown(NullPointerException.class, () -> Enumerable.of(1, 2, 3).aggregate(null));
	}

	@Test
	public void test01_02() {
		int actual = Enumerable.of(1, 2, 3).aggregate((n1, n2) -> n1 + n2);
		Assert.assertEquals(6, actual);
	}

	@Test
	public void test01_03() {
		Assert2.exceptionThrown(IllegalStateException.class, () -> Enumerable.empty(Integer.class).aggregate((n1, n2) -> n1 + n2));
	}

	@Test
	public void test02_01() {
		String actual =
				Enumerable
						.of(1, 2, 3)
						.aggregate(">", (n1, n2) -> n1 + n2);

		Assert.assertEquals(actual, ">123");
	}

	@Test
	public void test02_02() {
		String actual =
				Enumerable
						.of(1, 2, 3)
						.aggregate(">", (n1, n2) -> n1 + n2, n -> String.format("[%s]", n));

		Assert.assertEquals(actual, "[>123]");
	}
}
