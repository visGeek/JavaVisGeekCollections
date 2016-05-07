package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;

public class AsIntegerEnumerable {
	@Test
	public void isIIntegerEnumerable() {
		IEnumerable<Integer> source = Enumerable.ofInteger(1, 2, 3);
		IIntegerEnumerable source2 = source.asIntegerEnumerable();
		source2.sum();
	}

	@Test
	public void isIntegerEnumerable() {
		IEnumerable<Integer> source = Enumerable.of(1, 2, 3);
		IIntegerEnumerable source2 = source.asIntegerEnumerable();
		source2.sum();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		source.asIntegerEnumerable();
	}
}
