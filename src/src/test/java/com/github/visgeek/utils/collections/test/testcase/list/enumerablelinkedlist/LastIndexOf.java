package com.github.visgeek.utils.collections.test.testcase.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;

public class LastIndexOf {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2);
		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
	}
}
