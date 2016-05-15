package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IBooleanEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfBoolean {
	@Test
	public void test() {
		Boolean[] objectsEmpty = new Boolean[] {};
		Boolean[] objectsFilled = new Boolean[] { false, true, true };
		boolean[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		boolean[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Boolean, boolean[], IBooleanEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofBoolean,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
