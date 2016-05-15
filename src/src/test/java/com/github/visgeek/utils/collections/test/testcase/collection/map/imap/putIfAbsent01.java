package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.functions.Func0;

public class putIfAbsent01 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void valueIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("value");

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Func0<String> value = null;
		map.putIfAbsent(1, value);
	}

	@Test
	public void test() {
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>();
		enumerableMap.put(1, "a");
		enumerableMap.put(2, "b");
		enumerableMap.put(3, "c");
		enumerableMap.put(4, null);

		HashMap<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "a");
		hashMap.put(2, "b");
		hashMap.put(3, "c");
		hashMap.put(4, null);

		Func0<String> nonexecutableDefaultValue =
				() -> {
					Assert.fail();
					return null;
				};
		Assert.assertEquals(hashMap.putIfAbsent(1, "_"), enumerableMap.putIfAbsent(1, nonexecutableDefaultValue));
		Assert.assertEquals(hashMap.putIfAbsent(2, "_"), enumerableMap.putIfAbsent(2, nonexecutableDefaultValue));
		Assert.assertEquals(hashMap.putIfAbsent(3, "_"), enumerableMap.putIfAbsent(3, nonexecutableDefaultValue));
		Assert.assertEquals(hashMap.putIfAbsent(4, "_"), enumerableMap.putIfAbsent(4, () -> "_"));
		Assert.assertEquals(hashMap.putIfAbsent(5, null), enumerableMap.putIfAbsent(5, () -> null));
	}
}
