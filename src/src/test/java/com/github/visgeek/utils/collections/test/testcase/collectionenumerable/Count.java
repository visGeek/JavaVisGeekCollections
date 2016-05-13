package com.github.visgeek.utils.collections.test.testcase.collectionenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Count {
	@Test
	public void test() {
		IEnumerable<Item> source = Enumerable.of(new ItemCollection(1, 2, 3));
		int expected = 3;

		int actual = source.count();
		Assert.assertEquals(expected, actual);
	}
}
