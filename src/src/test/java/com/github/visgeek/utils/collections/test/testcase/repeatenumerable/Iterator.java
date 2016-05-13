package com.github.visgeek.utils.collections.test.testcase.repeatenumerable;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Iterator {
	@Test
	public void test() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		Assert2.assertSequanceEquals(source, "a", "a", "a");
	}
}
