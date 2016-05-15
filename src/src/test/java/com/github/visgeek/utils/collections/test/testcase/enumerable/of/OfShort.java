package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IShortEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfShort {
	@Test
	public void test() {
		Short[] objectsEmpty = new Short[] {};
		Short[] objectsFilled = new Short[] { 1, 2, 3 };
		short[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		short[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Short, short[], IShortEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofShort,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
