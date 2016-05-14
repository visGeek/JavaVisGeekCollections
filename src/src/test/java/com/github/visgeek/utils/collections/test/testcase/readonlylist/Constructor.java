package com.github.visgeek.utils.collections.test.testcase.readonlylist;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Constructor {
	@Test
	public void test() {
		List<Integer> source = Arrays.asList(1, 2, 3);
		int index = 0;
		int expected = 1;

		IEnumerable<Integer> enumerable = Enumerable.of(source);
		int actual = enumerable.elementAt(index);
		Assert.assertEquals(expected, actual);
	}
}
