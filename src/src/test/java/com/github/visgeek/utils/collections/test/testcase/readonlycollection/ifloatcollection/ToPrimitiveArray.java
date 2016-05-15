package com.github.visgeek.utils.collections.test.testcase.readonlycollection.ifloatcollection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IFloatEnumerable;

public class ToPrimitiveArray {
	@Test
	public void test() {
		Float[] source = new Float[] { null, 1.0f, 2.0f, 3.0f };
		float[] expected = new float[] { 0.0f, 1.0f, 2.0f, 3.0f };

		IFloatEnumerable enumerable = Enumerable.of(source);
		float[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
