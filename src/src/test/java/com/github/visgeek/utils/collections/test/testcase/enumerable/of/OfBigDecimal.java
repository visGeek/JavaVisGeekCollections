package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import java.math.BigDecimal;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;

public class OfBigDecimal {
	@Test
	public void test() {
		BigDecimal[] objectsEmpty = new BigDecimal[] {};
		BigDecimal[] objectsFilled = new BigDecimal[] { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(2) };
		int[] primitivesEmpty = null;
		int[] primitivesFilled = null;

		TestPatternCollection<BigDecimal, int[], IBigDecimalEnumerable> patterns =
				new TestPatternCollection<>(
						objectsEmpty,
						objectsFilled,
						primitivesEmpty,
						primitivesFilled,
						null,
						Enumerable::of,
						Enumerable::ofBigDecimal,
						enumerable -> enumerable.toArray(BigDecimal.class));

		patterns.run();
	}
}
