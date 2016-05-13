package com.github.visgeek.utils.collections.test.testcase.repeatenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void test() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		int expected = 3;

		int actual = source.count();
		Assert.assertEquals(expected, actual);
	}
}
