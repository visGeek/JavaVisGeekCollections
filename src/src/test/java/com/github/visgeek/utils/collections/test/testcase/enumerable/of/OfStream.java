package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class OfStream {
	@Test
	public void stringEmpty() {
		List<Integer> source = Arrays.asList();

		IEnumerable<Integer> enumerable = Enumerable.of(source.stream());
		Integer[] actual = enumerable.toArray(Integer.class);
		Assert.assertArrayEquals(source.toArray(new Integer[0]), actual);
	}

	@Test
	public void stringNotEmpty() {
		List<Integer> source = Arrays.asList(1, 2, 3);

		IEnumerable<Integer> enumerable = Enumerable.of(source.stream());
		Integer[] actual = enumerable.toArray(Integer.class);
		Assert.assertArrayEquals(source.toArray(new Integer[0]), actual);
	}
}
