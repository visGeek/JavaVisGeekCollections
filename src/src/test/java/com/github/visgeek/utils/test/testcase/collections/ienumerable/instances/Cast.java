package com.github.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Cast {
	@Test
	public void test_cast01() {
		try {
			IEnumerable<Object> objects = Enumerable.of("a", "b", "c");
			IEnumerable<String> strings = objects.cast(String.class);
			Assert2.assertSequanceEquals(strings, "a", "b", "c");

		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void test_cast02() {
		try {
			IEnumerable<Object> objects = Enumerable.of("a", "b", "c");
			IEnumerable<String> strings = objects.cast();
			Assert2.assertSequanceEquals(strings, "a", "b", "c");

		} catch (Exception e) {
			Assert.fail();
		}
	}
}
