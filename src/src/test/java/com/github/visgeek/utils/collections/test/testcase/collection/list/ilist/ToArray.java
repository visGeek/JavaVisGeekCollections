package com.github.visgeek.utils.collections.test.testcase.collection.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class ToArray {
	@Test
	public void empty() {
		EnumerableList<Integer> list = new EnumerableList<>();
		Integer[] actual = list.toArray(Integer.class);
		Assert.assertArrayEquals(actual, new Integer[] {});
	}

	@Test
	public void any() {
		EnumerableList<Integer> list = new EnumerableList<>();
		list.add(1);
		Integer[] actual = list.toArray(Integer.class);
		Assert.assertArrayEquals(actual, new Integer[] { 1 });
	}
}
