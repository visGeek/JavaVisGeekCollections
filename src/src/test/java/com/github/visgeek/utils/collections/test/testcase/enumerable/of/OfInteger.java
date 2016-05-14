package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfInteger {
	@Test
	public void test() {
		Integer[] objectsEmpty = new Integer[] {};
		Integer[] objectsFilled = new Integer[] { 1, 2, 3 };
		int[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		int[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Integer, int[], IIntegerEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofInteger,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
