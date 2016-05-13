package com.github.visgeek.utils.collections.test.testcase.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;

public class ToString {
	@Test
	public void test() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
		Assert.assertEquals("size:3", list.toString());
	}
}
