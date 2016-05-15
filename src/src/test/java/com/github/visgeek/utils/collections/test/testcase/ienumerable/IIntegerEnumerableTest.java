package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IIntegerEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IIntegerEnumerableTest {
	private final Integer[] sourceFilled = new Integer[] { null, 1, 2, 3, 4 };

	private final Integer[] sourceNullOnly = new Integer[] { null };

	private final Integer[] sourceEmpty = new Integer[] {};

	private final Double averageExpected = (double) ((long) 1 + (long) 2 + (long) 3 + (long) 4) / 4;

	private final int sumExpected = 1 + 2 + 3 + 4;

	@Test
	public void average() {
		// filled
		{
			IIntegerEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			IIntegerEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			IIntegerEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IIntegerEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		int actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}

	@Test
	public void toPrimitiveArray() {
		int[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IIntegerEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		int[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
