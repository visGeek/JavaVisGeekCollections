package com.github.visgeek.utils.collections.test.testcase.set.iset;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableSet;
import com.github.visgeek.utils.testing.Assert2;

public class ToArray {
	@Test
	public void test() {
		EnumerableSet<Integer> set = new EnumerableSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		Integer[] array = set.toArray(Integer.class);
		Assert.assertEquals(3, array.length);

		Arrays.sort(array);
		Assert2.assertSequanceEquals(Arrays.asList(array), 1, 2, 3);
	}
}
