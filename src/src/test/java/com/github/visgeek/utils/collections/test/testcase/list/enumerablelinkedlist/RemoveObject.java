package com.github.visgeek.utils.collections.test.testcase.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveObject {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
		Integer target = 2;
		boolean actual = list.remove(target);
		Assert.assertTrue(actual);
		Assert2.assertSequanceEquals(list, 1, 3);
	}
}
