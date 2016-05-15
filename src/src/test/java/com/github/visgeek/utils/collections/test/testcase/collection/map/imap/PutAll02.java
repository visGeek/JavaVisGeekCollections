package com.github.visgeek.utils.collections.test.testcase.collection.map.imap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.functions.Func1;

public class PutAll02 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void sourceIsNull() {
		EnumerableMap<String, String> map = new EnumerableMap<>();
		Iterable<Integer> source = null;
		Func1<Integer, String> keySelector = val -> "!" + val;
		Func1<Integer, String> valueSelector = val -> ">" + val;

		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("source");
		map.putAll(source, keySelector, valueSelector);
	}

	@Test
	public void keySelectorIsNull() {
		EnumerableMap<String, String> map = new EnumerableMap<>();
		Iterable<Integer> source = Arrays.asList();
		Func1<Integer, String> keySelector = null;
		Func1<Integer, String> valueSelector = val -> ">" + val;

		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("keySelector");
		map.putAll(source, keySelector, valueSelector);
	}

	@Test
	public void valueSelectorIsNull() {
		EnumerableMap<String, String> map = new EnumerableMap<>();
		Iterable<Integer> source = Arrays.asList();
		Func1<Integer, String> keySelector = val -> "!" + val;
		Func1<Integer, String> valueSelector = null;

		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("valueSelector");
		map.putAll(source, keySelector, valueSelector);
	}

	@Test
	public void test() {
		EnumerableMap<String, String> map = new EnumerableMap<>();
		Iterable<Integer> source = Arrays.asList(1, 2, 3);
		Func1<Integer, String> keySelector = val -> "!" + val;
		Func1<Integer, String> valueSelector = val -> ">" + val;

		map.putAll(source, keySelector, valueSelector);

		Assert.assertEquals(3, map.size());
		Assert.assertEquals(">1", map.getValue("!1"));
		Assert.assertEquals(">2", map.getValue("!2"));
		Assert.assertEquals(">3", map.getValue("!3"));
	}
}
