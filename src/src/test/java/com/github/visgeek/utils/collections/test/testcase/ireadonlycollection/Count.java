package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class Count {
	@Test
	public void empty() {
		EnumerableList<Integer> list = new EnumerableList<>();
		Assert.assertEquals(list.count(), 0);
	}

	@Test
	public void any() {
		EnumerableList<Integer> list = new EnumerableList<>();
		list.add(1);
		Assert.assertEquals(list.count(), 1);
	}
}
