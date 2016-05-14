package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Shift {
	@Test
	public void test01() {
		IEnumerable<Integer> source = Enumerable.range(0, 10).toList();
		IEnumerable<Integer> actual1 = source.shuffle().toList();
		IEnumerable<Integer> actual2 = source.shuffle().toList();
		Assert.assertFalse(source.sequenceEqual(actual1));
		Assert.assertFalse(source.sequenceEqual(actual2));
		Assert.assertFalse(actual1.sequenceEqual(actual2));
	}

	@Test
	public void test02() {
		long t = System.currentTimeMillis();

		IEnumerable<Integer> source = Enumerable.range(0, 10).toList();
		IEnumerable<Integer> actual1 = source.shuffle(new Random(t)).toList();
		IEnumerable<Integer> actual2 = source.shuffle(new Random(t)).toList();

		Assert.assertFalse(source.sequenceEqual(actual1));
		Assert.assertTrue(actual1.sequenceEqual(actual2));
	}
}
