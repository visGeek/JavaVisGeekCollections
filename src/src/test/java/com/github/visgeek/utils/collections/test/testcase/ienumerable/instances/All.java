package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;

public class All {
	@Test
	public void case01() {
		this.test(true, n -> n <= 3, 1, 2, 3);
	}

	@Test
	public void case02() {
		this.test(false, n -> n <= 3, 1, 2, 3, 4);
	}

	public void test(boolean expected, Func1<Integer, Boolean> predicate, Integer... source) {
		boolean actual = Enumerable.of(source).all(predicate);
		Assert.assertEquals(expected, actual);
	}
}
