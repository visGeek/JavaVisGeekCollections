package com.github.visgeek.utils.collections.test.testcase.enumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Empty {
	@Test
	public void test01() {
		IEnumerable<String> actual = Enumerable.empty();
		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void test02() {
		IEnumerable<String> actual = Enumerable.empty(String.class);
		Assert2.assertSequanceEquals(actual);
	}
}
