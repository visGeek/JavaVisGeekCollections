package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances.repeatenumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Contains {
	@Test
	public void containsTarget() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		String target = "a";
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void containsNull() {
		IEnumerable<String> source = Enumerable.repeat2(null, 3);
		String target = null;
		boolean expected = true;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContainsTargetIsNotNull() {
		IEnumerable<String> source = Enumerable.repeat2(null, 3);
		String target = "a";
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void sourceIsEmpty() {
		IEnumerable<String> source = Enumerable.repeat2("a", 0);
		String target = "a";
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContainsTarget01() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		String target = "b";
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void notContainsTarget02() {
		IEnumerable<String> source = Enumerable.repeat2("a", 3);
		String target = null;
		boolean expected = false;

		boolean actual = source.contains(target);
		Assert.assertEquals(expected, actual);
	}
}
