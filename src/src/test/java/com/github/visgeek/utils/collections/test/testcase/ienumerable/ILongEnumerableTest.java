package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.ILongEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class ILongEnumerableTest {
	private final Long[] sourceFilled = new Long[] { null, 1L, 2L, 3L, 4L };

	private final Long[] sourceNullOnly = new Long[] { null };

	private final Long[] sourceEmpty = new Long[] {};

	private final Double averageExpected = (double) (1L + 2L + 3L + 4L) / 4;

	private final long sumExpected = 1L + 2L + 3L + 4L;

	@Test
	public void average() {
		// filled
		{
			ILongEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			ILongEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			ILongEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		ILongEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		long actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}

	@Test
	public void toPrimitiveArray() {
		long[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		ILongEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		long[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual);
	}
}
