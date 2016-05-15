package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfDouble {
	@Test
	public void test() {
		Double[] objectsEmpty = new Double[] {};
		Double[] objectsFilled = new Double[] { 1.0, 2.0, 3.0 };
		double[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		double[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Double, double[], IDoubleEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofDouble,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
