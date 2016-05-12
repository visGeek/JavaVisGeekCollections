package com.github.visgeek.utils.collections.test.testcase.map.imap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.EnumerableMap;

public class PutAll01 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void valuesIsNull() {
		EnumerableMap<String, Integer> map = new EnumerableMap<>();
		Iterable<Integer> values = null;
		Func1<Integer, String> keySelector = val -> "!" + val;

		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("values");
		map.putAll(values, keySelector);
	}

	@Test
	public void keySelectorIsNull() {
		EnumerableMap<String, Integer> map = new EnumerableMap<>();
		Iterable<Integer> values = Arrays.asList();
		Func1<Integer, String> keySelector = null;

		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("keySelector");
		map.putAll(values, keySelector);
	}

	@Test
	public void test() {
		EnumerableMap<String, Integer> map = new EnumerableMap<>();
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		Func1<Integer, String> keySelector = val -> "!" + val;

		map.putAll(values, keySelector);

		Assert.assertEquals(3, map.size());
		Assert.assertEquals(1, (int) map.getValue("!1"));
		Assert.assertEquals(2, (int) map.getValue("!2"));
		Assert.assertEquals(3, (int) map.getValue("!3"));
	}
}
