package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.collections.EnumerableMap;

public class RemoveValueOrDefault02 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void defaultValueIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("defaultValue");

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Func0<String> defaultValue = null;
		map.removeValueOrDefault(4, defaultValue);
	}

	@Test
	public void defaultValueGetterFromNoArg() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("_", map.removeValueOrDefault(4, () -> "_"));
		Assert.assertEquals(null, map.removeValueOrDefault(4, () -> (String) null));
		Assert.assertEquals(3, map.size());

		Func0<String> nonexecutableDefaultValue =
				() -> {
					Assert.fail();
					return null;
				};
		Assert.assertEquals("a", map.removeValueOrDefault(1, nonexecutableDefaultValue));
		Assert.assertEquals("b", map.removeValueOrDefault(2, nonexecutableDefaultValue));
		Assert.assertEquals("c", map.removeValueOrDefault(3, nonexecutableDefaultValue));
		Assert.assertEquals(0, map.size());

		Assert.assertEquals("_", map.removeValueOrDefault(4, () -> "_"));
		Assert.assertEquals(null, map.removeValueOrDefault(4, () -> (String) null));
		Assert.assertEquals(0, map.size());
	}
}
