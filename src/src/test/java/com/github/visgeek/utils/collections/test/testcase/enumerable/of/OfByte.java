package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfByte {
	@Test
	public void test() {
		Byte[] objectsEmpty = new Byte[] {};
		Byte[] objectsFilled = new Byte[] { 1, 2, 3 };
		byte[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		byte[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Byte, byte[], IByteEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofByte,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
