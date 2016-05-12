package com.github.visgeek.utils.collections.test.testcase.list.ilist;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveAllValues {
	@Test
	@SuppressWarnings("deprecation")
	public void removeAllCollection() {
		Collection<Integer> targetCollection = Arrays.asList(2, 3);
		Iterable<Integer> targetIterable = () -> targetCollection.iterator();

		EnumerableList<Integer> list1 = new EnumerableList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(4);

		EnumerableList<Integer> list2 = list1.clone();
		EnumerableList<Integer> list3 = list1.clone();

		// target をすべて消して更にもう一回試みる。
		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.removeAll(targetCollection);
			boolean result2 = list2.removeAllValues(targetCollection);
			boolean result3 = list3.removeAllValues(targetIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result2, result1);
			Assert.assertEquals(message, result3, result1);

			Assert2.assertSequanceEquals(message, list2, list1);
			Assert2.assertSequanceEquals(message, list3, list1);
		}
	}
}
