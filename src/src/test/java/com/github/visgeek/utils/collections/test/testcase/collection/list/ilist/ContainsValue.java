package com.github.visgeek.utils.collections.test.testcase.collection.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class ContainsValue {
	@Test
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		Assert.assertTrue(list.containsValue(1));
		Assert.assertFalse(list.containsValue(4));
	}
}
