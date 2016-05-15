package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IBooleanEnumerable;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class AsBooleanEnumerable {
	@Test
	public void isIBooleanEnumerable() {
		IEnumerable<Boolean> source = Enumerable.of(false, true, true);
		IBooleanEnumerable source2 = source.asBooleanEnumerable();
		source2.toPrimitiveArray();
	}

	@Test
	public void isBooleanEnumerable() {
		IEnumerable<Boolean> source = () -> CollectionCreator.iterator(false, true, true);
		IBooleanEnumerable source2 = source.asBooleanEnumerable();
		source2.toPrimitiveArray();
	}

	@Test
	public void noException() {
		IEnumerable<String> source = Enumerable.of("a", "b", "c");
		Action0 action = () -> source.asBooleanEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
