package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfLong {
	@Test
	public void test() {
		Long[] objectsEmpty = new Long[] {};
		Long[] objectsFilled = new Long[] { 1L, 2L, 3L };
		long[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		long[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Long, long[], ILongEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofLong,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
