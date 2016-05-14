package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelinkedlist;

import java.util.Arrays;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.testing.Assert2;

public class Create01 {
	@Test
	public void test() {
		EnumerableLinkedList<Integer> list = EnumerableLinkedList.create(Arrays.asList(1, 2, 3));
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}
}
