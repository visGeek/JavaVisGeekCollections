package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.test.testcase.enumerable.of.IBigDecimalEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

public class IBigDecimalEnumerableTest {
	private final BigDecimal[] sourceFilled = new BigDecimal[] { null, BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4) };

	private final BigDecimal[] sourceNullOnly = new BigDecimal[] { null };

	private final BigDecimal[] sourceEmpty = new BigDecimal[] {};

	private final BigDecimal averageExpected = BigDecimal.valueOf(1).add(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(4)).divide(BigDecimal.valueOf(4));

	private final BigDecimal sumExpected = BigDecimal.valueOf(1).add(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(3)).add(BigDecimal.valueOf(4));

	@Test
	public void average() {
		// filled
		{
			IBigDecimalEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
			BigDecimal actual = enumerable.average();
			Assert.assertEquals(this.averageExpected, actual);
		}

		// null only
		{
			BigDecimal expected = null;
			IBigDecimalEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceNullOnly);
			BigDecimal actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}

		// empty
		{
			BigDecimal expected = null;
			IBigDecimalEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceEmpty);
			BigDecimal actual = enumerable.average();
			Assert.assertEquals(expected, actual);
		}
	}

	@Test
	public void sum() {
		IBigDecimalEnumerable enumerable = () -> CollectionCreator.iterator(this.sourceFilled);
		BigDecimal actual = enumerable.sum();
		Assert.assertEquals(this.sumExpected, actual);
	}
}
