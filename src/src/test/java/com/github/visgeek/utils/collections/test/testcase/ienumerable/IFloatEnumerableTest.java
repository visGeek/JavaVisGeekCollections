package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.IFloatEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IFloatEnumerableTest {
	private final Float[] sourceFilled = new Float[] { null, 1.0f, 2.0f, 3.0f, 4.0f };

	private final Float[] sourceNullOnly = new Float[] { null };

	private final Float[] sourceEmpty = new Float[] {};

	private final Float averageExpected = (float) (((double) 1.0f + (double) 2.0f + (double) 3.0f + (double) 4.0f) / 4);

	private final float sumExpected = (float) ((double) 1.0f + (double) 2.0f + (double) 3.0f + (double) 4.0f);

	@Test
	public void average() {
		// filled
		{
			IFloatEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			Float actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			Float expected = null;
			IFloatEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			Float actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			Float expected = null;
			IFloatEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			Float actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IFloatEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		float actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual, 0);
	}

	@Test
	public void toPrimitiveArray() {
		float[] expected = CollectionCreator.primitiveArray(this.sourceFilled);

		IFloatEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		float[] actual = enumerable.toPrimitiveArray();
		Assert.assertArrayEquals(expected, actual, 0);
	}
}
