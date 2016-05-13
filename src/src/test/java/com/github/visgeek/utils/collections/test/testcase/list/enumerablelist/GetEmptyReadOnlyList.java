package com.github.visgeek.utils.collections.test.testcase.list.enumerablelist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IReadOnlyList;

public class GetEmptyReadOnlyList {
	@Test
	public void test() {
		IReadOnlyList<Integer> list = EnumerableList.getEmptyReadOnlyList();
		Assert.assertTrue(list.isEmpty());
	}
}
