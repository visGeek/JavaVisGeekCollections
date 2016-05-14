package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelist;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveAll {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3, 2, 4);
		Collection<Integer> targetCollection = Arrays.asList(2, 3);
		list.removeAll(targetCollection);
		Assert2.assertSequanceEquals(list, 1, 4);
	}
}
