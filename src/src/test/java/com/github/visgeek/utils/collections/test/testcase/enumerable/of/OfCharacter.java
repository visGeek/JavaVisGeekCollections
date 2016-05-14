package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class OfCharacter {
	@Test
	public void test() {
		Character[] objectsEmpty = new Character[] {};
		Character[] objectsFilled = new Character[] { 1, 2, 3 };
		char[] primitivesEmpty = CollectionCreator.primitiveArray(objectsEmpty);
		char[] primitivesFilled = CollectionCreator.primitiveArray(objectsFilled);

		TestPatternCollection<Character, char[], ICharacterEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						Enumerable::of,
						Enumerable::of,
						Enumerable::ofCharacter,
						enumerable -> enumerable.toPrimitiveArray());

		patterns.run();
	}
}
