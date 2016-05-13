package com.github.visgeek.utils.collections.test.testcase.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class Clone {
	@Test
	public void clone01() {
		EnumerableList<Integer> list1 = new EnumerableList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		EnumerableList<Integer> list2 = list1.clone();

		Assert.assertNotSame(list1, list2);
		Assert2.assertSequanceEquals(list1, list2);

		list1.add(4);
		Assert.assertNotEquals(list1.size(), list2.size());
	}
}
