package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;

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
		source.asDoubleEnumerable();
	}
}
