package com.github.visgeek.utils.collections.test.testcase.collection.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveValue {
	/**
	 * List&tl;T&gt;.Remove(T) と同じ動作かどうかを確認する。
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void removeObject_removeValue() {
		int target = 2;

		EnumerableList<Integer> list1 = new EnumerableList<>();
		list1.add(target - 1);
		list1.add(target);
		list1.add(target + 1);
		list1.add(target);

		EnumerableList<Integer> list2 = list1.clone();

		// target をすべて消して更にもう一回試みる。
		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.remove(Integer.valueOf(target));
			boolean result2 = list2.removeValue(target);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result1, result2);
			Assert2.assertSequanceEquals(message, list1, list2);
		}
	}
}
