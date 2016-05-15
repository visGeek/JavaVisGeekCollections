package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IDoubleEnumerableTest {
	private final Double[] sourceFilled = new Double[] { null, 1.0, 2.0, 3.0, 4.0 };

	private final Double[] sourceNullOnly = new Double[] { null };

	private final Double[] sourceEmpty = new Double[] {};

	private final Double averageExpected = (double) (1.0 + 2.0 + 3.0 + 4.0) / 4;

	private final double sumExpected = 1.0 + 2.0 + 3.0 + 4.0;

	@Test
	public void average() {
		// filled
		{
			IDoubleEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Double actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Double expected = null;
			IDoubleEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Double expected = null;
			IDoubleEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Double actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IDoubleEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		double actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual, 0);
	}

	@Test
	public void toPrimitiveArray() {
		double[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IDoubleEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		double[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
