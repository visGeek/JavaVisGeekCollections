package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.ICharacterEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class ICharacterEnumerableTest {
	private final Character[] sourceFilled = new Character[] { null, 1, 2, 3, 4 };

	private final Character[] sourceNullOnly = new Character[] { null };

	private final Character[] sourceEmpty = new Character[] {};

	private final Double averageExpected = (double) (1 + 2 + 3 + 4) / 4;

	private final int sumExpected = 1 + 2 + 3 + 4;

	@Test
	public void average() {
		// filled
		{
			ICharacterEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			ICharacterEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			ICharacterEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		ICharacterEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		int actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}

	@Test
	public void toPrimitiveArray() {
		char[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		ICharacterEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		char[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
