package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;

public class AverageFloat {
	@Test
	public void test() {
		Float[] source = new Float[] { null, 1.0f, 2.0f, 3.0f, 4.0f };
		Float expected = (1.0f + 2.0f + 3.0f + 4.0f) / 4;

		IEnumerable<Float> enumerable = () -> Arrays.asList(source).iterator();
		Float actual = enumerable.averageFloat(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void empty() {
		Float[] source = new Float[] {};
		Float expected = null;

		IEnumerable<Float> enumerable = () -> Arrays.asList(source).iterator();
		Float actual = enumerable.averageFloat(n -> n);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void nullAll() {
		Float[] source = new Float[] { null, null, null };
		Float expected = null;

		IEnumerable<Float> enumerable = () -> Arrays.asList(source).iterator();
		Float actual = enumerable.averageFloat(n -> n);
		Assert.assertEquals(expected, actual);
	}
}
