package com.github.visgeek.utils.collections.test.testcase.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class LastIndexOf {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3, 2);
		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
	}
}
