package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

public class RemoveIndex {
	@Test
	@SuppressWarnings("deprecation")
	public void test() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);

		{
			int index = 1;
			int expected = 2;
			Integer actual = list.remove(index);
			Assert.assertEquals(expected, (int) actual);
		}

		{
			int index = 0;
			int expected = 1;
			Integer actual = list.remove(index);
			Assert.assertEquals(expected, (int) actual);
		}
	}
}
