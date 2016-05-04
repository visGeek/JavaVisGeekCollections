package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class ToString {
	@Test
	public void test_toString01() {
		String actual = Enumerable.of(1, 2, 3, 4).toString(", ");
		Assert.assertEquals("1, 2, 3, 4", actual);
	}

	@Test
	public void test_toString02() {
		String actual = Enumerable.of(1, 2, 3, 4).toString(", ", n -> n.toString() + "m");
		Assert.assertEquals("1m, 2m, 3m, 4m", actual);
	}
}
