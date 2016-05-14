package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;

public class Contains {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
		Assert.assertTrue(list.contains(1));
		Assert.assertFalse(list.contains(4));
	}
}
