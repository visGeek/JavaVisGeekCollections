package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelist;

import java.util.Arrays;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class Create01 {
	@Test
	public void test() {
		EnumerableList<Integer> list = EnumerableList.create(Arrays.asList(1, 2, 3));
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}
}
