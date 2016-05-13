package com.github.visgeek.utils.collections.test.testcase.enumerable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class OfCharacter {
	@Test
	public void iEnumerable_empty() {
		IEnumerable<Character> source = Enumerable.ofCharacter(Arrays.asList());
		IEnumerable<Character> actual = Enumerable.ofCharacter(source);
		Assert.assertSame(source, actual);
	}

	@Test
	public void iEnumerable_normal() {
		IEnumerable<Character> source = Enumerable.of('a', 'b', 'c');
		IEnumerable<Character> actual = Enumerable.ofCharacter(source);
		Assert.assertSame(source, actual);
	}

	@Test
	public void primitiveArray_empty() {
		char[] values = new char[] {};
		IEnumerable<Character> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void primitiveArray_normal() {
		char[] values = new char[] { 'a', 'b', 'c' };
		IEnumerable<Character> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void objectArray_empty() {
		Character[] values = new Character[] {};
		IEnumerable<Character> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void objectArray_normal() {
		Character[] values = new Character[] { 'a', 'b', 'c' };
		IEnumerable<Character> actual = Enumerable.of(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void randomAccesss_empty() {
		List<Character> values = new ArrayList<>();
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void randomAccesss_normal() {
		List<Character> values = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void collection_empty() {
		List<Character> values = new LinkedList<>();
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void collection_normal() {
		List<Character> values = new LinkedList<>(Arrays.asList('a', 'b', 'c'));
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void iterable_empty() {
		Iterable<Character> values = () -> new ArrayList<Character>().iterator();
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void iterable_normal() {
		Iterable<Character> values = () -> new ArrayList<>(Arrays.asList('a', 'b', 'c')).iterator();
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}

	@Test
	public void string_empty() {
		String values = "";
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual);
	}

	@Test
	public void string_normal() {
		String values = "abc";
		IEnumerable<Character> actual = Enumerable.ofCharacter(values);

		Assert2.assertSequanceEquals(actual, 'a', 'b', 'c');
	}
}
