package com.github.visgeek.utils.collections.test.testcase.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveAt {
	/**
	 * List&tl;T&gt;.remove(int) と同じ動作かどうかを確認する。
	 */
	@Test
	@SuppressWarnings("deprecation")
	public void removeIndex_removeAt() {
		EnumerableList<Integer> list1 = new EnumerableList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		EnumerableList<Integer> list2 = list1.clone();

		int index = 1;
		Integer result1 = list1.remove(index);
		Integer result2 = list2.removeAt(index);

		Assert.assertEquals(Integer.valueOf(2), result1);
		Assert.assertEquals(result1, result2);
		Assert2.assertSequanceEquals(list1, list2);
	}
}
