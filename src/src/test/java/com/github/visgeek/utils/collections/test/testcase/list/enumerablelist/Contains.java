package com.github.visgeek.utils.collections.test.testcase.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class Contains {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);
		Assert.assertTrue(list.contains(1));
		Assert.assertFalse(list.contains(4));
	}
}
