package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IFloatEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfFloat {
	@Test
	public void test() {
		Float[] objectsEmpty = new Float[] {};
		Float[] objectsFilled = new Float[] { 1.0f, 2.0f, 3.0f };
		float[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		float[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Float, float[], IFloatEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofFloat,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
