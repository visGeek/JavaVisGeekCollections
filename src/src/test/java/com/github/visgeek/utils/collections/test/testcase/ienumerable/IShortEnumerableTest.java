package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IShortEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IShortEnumerableTest {
	private final Short[] sourceFilled = new Short[] { null, 1, 2, 3, 4 };

	private final Short[] sourceNullOnly = new Short[] { null };

	private final Short[] sourceEmpty = new Short[] {};

	private final Double averageExpected = (double) (1 + 2 + 3 + 4) / 4;

	private final int sumExpected = 1 + 2 + 3 + 4;

	@Test
	public void average() {
		// filled
		{
			IShortEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			IShortEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			IShortEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IShortEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		int actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}

	@Test
	public void toPrimitiveArray() {
		short[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IShortEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		short[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
