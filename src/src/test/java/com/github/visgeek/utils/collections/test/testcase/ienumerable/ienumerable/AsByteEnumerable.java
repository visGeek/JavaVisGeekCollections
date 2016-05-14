package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class AsByteEnumerable {
	@Test
	public void isILongEnumerable() {
		Byte[] source = new Byte[] { 1, 2, 3 };

		IEnumerable<Byte> enumerable = Enumerable.of(source);
		IByteEnumerable byteEnumerable = enumerable.asByteEnumerable();
		byteEnumerable.toPrimitiveArray();
	}

	@Test
	public void isByteEnumerable() {
		Byte[] source = new Byte[] { 1, 2, 3 };

		IEnumerable<Byte> enumerable = () -> Enumerable.of(source).iterator();
		IByteEnumerable byteEnumerable = enumerable.asByteEnumerable();
		byteEnumerable.toPrimitiveArray();
	}

	@Test
	public void noException() {
		String[] source = new String[] { "a", "b", "c" };

		IEnumerable<String> enumerable = Enumerable.of(source);
		Action0 action = () -> enumerable.asByteEnumerable();
		Assert2.assertExceptionNotThrown(action);
	}
}
