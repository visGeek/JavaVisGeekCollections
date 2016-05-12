package com.github.visgeek.utils.collections.test.testcase.list.ilist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;

/**
 * List&tl;T&gt; の indexOf() と同じ動作かどうかを確認する。
 *
 */
public class IndexValueOf {
	@Test
	@SuppressWarnings("deprecation")
	public void indexOf() {
		EnumerableList<Integer> list = new EnumerableList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);

		Assert.assertEquals(1, list.indexOf(2));
		Assert.assertEquals(-1, list.indexOf(4));
		Assert.assertEquals(list.indexOf(2), list.indexOfValue(2));
		Assert.assertEquals(list.indexOf(4), list.indexOfValue(4));
	}
}
