package com.github.visgeek.utils.collections.test.testcase.collection.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

/**
 * List&tl;T&gt; の lastIndexOf() と同じ動作かどうかを確認する。
 *
 */
public class LastIndexOfValue {
	@Test
	@SuppressWarnings("deprecation")
	public void lastIndexOf() {
		EnumerableList<Integer> list = new EnumerableList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);

		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
		Assert.assertEquals(list.lastIndexOf(2), list.lastIndexOfValue(2));
		Assert.assertEquals(list.lastIndexOf(4), list.lastIndexOfValue(4));
	}
}
