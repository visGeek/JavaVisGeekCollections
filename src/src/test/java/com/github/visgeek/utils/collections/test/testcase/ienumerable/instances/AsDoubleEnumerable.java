package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsDoubleEnumerable {
	@Test
	public void isIDoubleEnumerable() {
		IEnumerable<Double> source = Enumerable.ofDouble(1.0, 2.0, 3.0);
		IDoubleEnumerable source2 = source.asDoubleEnumerable();
		source2.sum();
	}

	@Test
	public void isDoubleEnumerable() {
		IEnumerable<Double> source = Enumerable.of(1.0, 2.0, 3.0);
		IDoubleEnumerable source2 = source.asDoubleEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asDoubleEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
