package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Of {
	@Test
	public void test() {
		Object[] objectsEmpty = new Object[] {};
		Object[] objectsFilled = new Object[] { "a", "b", "c" };
		int[] primitivesEmpty = null;
		int[] primitivesFilled = null;

		TestPatternCollection<Object, int[], IEnumerable<Object>> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						null,
						Enumerable::of,
						Enumerable::of,
						enumerable -> enumerable.toArray(Object.class));

		patterns.run();
	}
}
