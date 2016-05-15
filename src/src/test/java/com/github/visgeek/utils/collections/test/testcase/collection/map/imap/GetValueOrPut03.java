package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.functions.Func0;

public class GetValueOrPut03 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void defaultValueIsNullWithoutLock() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("defaultValue");

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Func0<String> defaultValue = null;
		map.getValueOrPut(1, defaultValue);
	}

	@Test
	public void defaultValueIsNullInternal() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("defaultValue");

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Func0<String> defaultValue = null;
		map.getValueOrPut(1, defaultValue, new Object());
	}

	@Test
	public void withoutLock() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("a", map.getValueOrPut(1, key -> key.toString()));
		Assert.assertEquals("b", map.getValueOrPut(2, key -> key.toString()));
		Assert.assertEquals("c", map.getValueOrPut(3, key -> key.toString()));
		Assert.assertEquals("4", map.getValueOrPut(4, key -> key.toString()));
		Assert.assertEquals(null, map.getValueOrPut(5, key -> (String) null));

		// 新しいエントリーが登録されている。
		Assert.assertEquals("4", map.getValue(4));
		Assert.assertEquals(null, map.getValue(5));
	}

	@Test
	public void withLock() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Object lockObjectOrNull = new Object();
		Assert.assertEquals("a", map.getValueOrPut(1, key -> key.toString(), lockObjectOrNull));
		Assert.assertEquals("b", map.getValueOrPut(2, key -> key.toString(), lockObjectOrNull));
		Assert.assertEquals("c", map.getValueOrPut(3, key -> key.toString(), lockObjectOrNull));
		Assert.assertEquals("4", map.getValueOrPut(4, key -> key.toString(), lockObjectOrNull));
		Assert.assertEquals(null, map.getValueOrPut(5, key -> (String) null, lockObjectOrNull));

		// 新しいエントリーが登録されている。
		Assert.assertEquals("4", map.getValue(4));
		Assert.assertEquals(null, map.getValue(5));
	}
}
