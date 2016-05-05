package com.github.visgeek.utils.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class Func1Test {
	@Test
	public void normal() {
		Func1<Integer, List<Integer>> func = (arg1) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void partialApply() {
		Func1<Integer, List<Integer>> func = (arg1) -> Functions.toList(arg1);
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.partialApply(1).func();

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException01() {
		Func1<Integer, List<Integer>> func = Func1.create((arg1) -> Functions.toListOrThrow(false, arg1));
		Integer[] expected = new Integer[] { 1 };
		List<Integer> actual = func.func(1);

		Assert2.assertSequanceEquals(actual, expected);
	}

	@Test
	public void wrapThrowsException02() {
		Func1<Integer, List<Integer>> func = Func1.create((arg1) -> Functions.toListOrThrow(true));
		Assert2.exceptionThrown(RuntimeException.class, () -> func.func(1));
	}

	@Test
	public void mergePredicateArary() {
		Func1<Integer, Boolean> predicate1 = n -> 1 <= n;
		Func1<Integer, Boolean> predicate2 = n -> n <= 3;
		Func1<Integer, Boolean> predicate3 = Func1.mergePredicates(predicate1, predicate2);
		Assert.assertFalse(predicate3.func(0));
		Assert.assertTrue(predicate3.func(1));
		Assert.assertTrue(predicate3.func(2));
		Assert.assertTrue(predicate3.func(3));
		Assert.assertFalse(predicate3.func(4));
	}

	@Test
	public void mergePredicateIterable() {
		Func1<Integer, Boolean> predicate1 = n -> 1 <= n;
		Func1<Integer, Boolean> predicate2 = n -> n <= 3;
		Func1<Integer, Boolean> predicate3 = Func1.mergePredicates(Arrays.asList(predicate1, predicate2));
		Assert.assertFalse(predicate3.func(0));
		Assert.assertTrue(predicate3.func(1));
		Assert.assertTrue(predicate3.func(2));
		Assert.assertTrue(predicate3.func(3));
		Assert.assertFalse(predicate3.func(4));
	}
}
