package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveObject {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);
		Integer target = 2;
		boolean actual = list.remove(target);
		Assert.assertTrue(actual);
		Assert2.assertSequanceEquals(list, 1, 3);
	}
}
