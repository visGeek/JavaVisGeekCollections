package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.math.BigDecimal;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.test.testcase.enumerable.of.IBigDecimalEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class AsBigDecimalEnumerable {
	@Test
	public void isIBigDecimalEnumerable() {
		IEnumerable<BigDecimal> source = Enumerable.of(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3));
		IBigDecimalEnumerable source2 = source.asBigDecimalEnumerable();
		source2.sum();
	}

	@Test
	public void isBigDecimalEnumerable() {
		IEnumerable<BigDecimal> source = () -> CollectionCreator.iterator(BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3));
		IBigDecimalEnumerable source2 = source.asBigDecimalEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asBigDecimalEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
