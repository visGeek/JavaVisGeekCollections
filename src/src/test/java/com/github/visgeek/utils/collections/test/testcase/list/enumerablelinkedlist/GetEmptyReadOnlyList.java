package com.github.visgeek.utils.collections.test.testcase.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.collections.IReadOnlyList;

public class GetEmptyReadOnlyList {
	@Test
	public void test() {
		IReadOnlyList<Integer> list = EnumerableLinkedList.getEmptyReadOnlyList();
		Assert.assertTrue(list.isEmpty());
	}
}
