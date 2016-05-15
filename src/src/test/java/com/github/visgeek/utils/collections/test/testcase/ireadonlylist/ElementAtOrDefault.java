package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.functions.Func0;

public class ElementAtOrDefault {
	@Test
	public void defaultValueExists_success() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = 1;
		Func0<Integer> defaultValue = () -> 0;
		Integer expected = 2;

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void defaultValueExists_fail_01() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = -1;
		Func0<Integer> defaultValue = () -> 0;
		Integer expected = defaultValue.func();

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void defaultValueExists_fail_02() {
		Integer[] source = new Integer[] { 1, 2, 3 };
		int index = 3;
		Func0<Integer> defaultValue = () -> 0;
		Integer expected = defaultValue.func();

		TestList<Integer> collection = new TestList<>(source);
		Integer actual = collection.elementAtOrDefault(index, defaultValue);
		Assert.assertEquals(expected, actual);
	}
}
