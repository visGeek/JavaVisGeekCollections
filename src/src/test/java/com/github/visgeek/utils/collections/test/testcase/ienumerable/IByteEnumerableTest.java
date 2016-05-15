package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IByteEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IByteEnumerableTest {
	private final Byte[] sourceFilled = new Byte[] { null, 1, 2, 3, 4 };

	private final Byte[] sourceNullOnly = new Byte[] { null };

	private final Byte[] sourceEmpty = new Byte[] {};

	private final Double averageExpected = (double) (1 + 2 + 3 + 4) / 4;

	private final int sumExpected = 1 + 2 + 3 + 4;

	@Test
	public void average() {
		// filled
		{
			IByteEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			IByteEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			IByteEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IByteEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		int actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}

	@Test
	public void toPrimitiveArray() {
		byte[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IByteEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		byte[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
