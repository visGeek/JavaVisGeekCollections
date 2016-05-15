package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.functions.Func1;

public class RemoveValueOrDefault03 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void defaultValueIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("defaultValue");

		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		Func1<Integer, String> defaultValue = null;
		map.removeValueOrDefault(4, defaultValue);
	}

	@Test
	public void defaultValueGetterFromKey() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Assert.assertEquals("!4", map.removeValueOrDefault(4,  key -> "!" + key));
		Assert.assertEquals(null, map.removeValueOrDefault(4, key -> (String) null));
		Assert.assertEquals(3, map.size());

		Func1<Integer, String> nonexecutableDefaultValue =
				key -> {
					Assert.fail();
					return null;
				};
		Assert.assertEquals("a", map.removeValueOrDefault(1, nonexecutableDefaultValue));
		Assert.assertEquals("b", map.removeValueOrDefault(2, nonexecutableDefaultValue));
		Assert.assertEquals("c", map.removeValueOrDefault(3, nonexecutableDefaultValue));
		Assert.assertEquals(0, map.size());

		Assert.assertEquals("!4", map.removeValueOrDefault(4, key -> "!" + key));
		Assert.assertEquals(null, map.removeValueOrDefault(4, key -> (String) null));
		Assert.assertEquals(0, map.size());
	}
}
