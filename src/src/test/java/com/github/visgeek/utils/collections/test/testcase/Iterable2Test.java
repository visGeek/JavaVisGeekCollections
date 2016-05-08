package com.github.visgeek.utils.collections.test.testcase;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Iterable2;

public class Iterable2Test {
	@Test
	public void case01() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Iterable2<Integer> i2 = () -> list.iterator();
		int actual = i2.asEnumerable().aggregate((prev, next) -> prev + next);
		Assert.assertEquals(6, actual);
	}
}
