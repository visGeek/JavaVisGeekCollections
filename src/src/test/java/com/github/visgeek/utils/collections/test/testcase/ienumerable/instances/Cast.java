package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class Cast {
	@Test
	public void cast01_argIsNull() {
		IEnumerable<Object> objects = Enumerable.of("a", "b", "c");
		Action0 action = () -> objects.cast(null);
		Assert2.assertNullPointerExceptionThrown("elementClass", action);
	}

	@Test
	public void cast01_ObjectToString() {
		IEnumerable<Object> objects = Enumerable.of("a", "b", "c");

		// cast() でエラーが発生しない。
		Action0 action = () -> objects.cast(String.class);
		Assert2.assertExceptionNotThrown(action);

		// 列挙できる。
		IEnumerable<String> strings = objects.cast(String.class);
		Assert2.assertSequanceEquals(strings, "a", "b", "c");
	}

	@Test
	public void cast01_IntegerToString() {
		IEnumerable<Object> objects = Enumerable.of("a", "b", "c");

		// cast() でエラーが発生しない。
		Action0 action1 = () -> objects.cast(Integer.class);
		Assert2.assertExceptionNotThrown(action1);

		// 列挙するとエラー。
		Action0 action2 = () -> objects.cast(Integer.class).sumInteger(n -> n);
		Assert2.assertExceptionThrown(ClassCastException.class, action2);
	}

	@Test
	public void cast02_ObjectToString() {
		IEnumerable<Object> objects = Enumerable.of("a", "b", "c");

		// cast() でエラーが発生しない。
		Action0 action = () -> objects.<String> cast();
		Assert2.assertExceptionNotThrown(action);

		// 列挙できる。
		IEnumerable<String> strings = objects.<String> cast();
		Assert2.assertSequanceEquals(strings, "a", "b", "c");
	}

	@Test
	public void cast02_IntegerToString() {
		IEnumerable<Object> objects = Enumerable.of("a", "b", "c");

		// cast() でエラーが発生しない。
		Action0 action1 = () -> objects.<Integer> cast();
		Assert2.assertExceptionNotThrown(action1);

		// 列挙するとエラー。
		Action0 action2 = () -> objects.<Integer> cast().sumInteger(n -> n);
		Assert2.assertExceptionThrown(ClassCastException.class, action2);
	}
}
