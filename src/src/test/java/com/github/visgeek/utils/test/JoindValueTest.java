package com.github.visgeek.utils.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.JoinedValue;

public class JoindValueTest {
	@Test
	public void Test01() {
		JoinedValue<Integer, Integer> val1_1 = JoinedValue.create(1, 1);
		JoinedValue<Integer, Integer> val1_2 = JoinedValue.create(1, 2);
		JoinedValue<Integer, Integer> val1_3 = JoinedValue.create(1, 3);
		JoinedValue<Integer, Integer> val2_1 = JoinedValue.create(2, 1);
		JoinedValue<Integer, Integer> val2_2 = JoinedValue.create(2, 2);
		JoinedValue<Integer, Integer> val2_3 = JoinedValue.create(2, 3);

		JoinedValue<Integer, Integer> testValue1_3 = new JoinedValue<Integer, Integer>(1, 3);
		JoinedValue<Integer, Integer> testValue3_1 = new JoinedValue<Integer, Integer>(3, 1);

		Assert.assertEquals(val1_3.outer(), Integer.valueOf(1));
		Assert.assertEquals(val1_3.inner(), Integer.valueOf(3));

		Assert.assertNotEquals(val1_3, 1);
		Assert.assertNotEquals(val1_3, JoinedValue.create("", ""));
		Assert.assertFalse(val1_3.equals((JoinedValue<Integer, Integer>) null));
		Assert.assertEquals(val1_3, testValue1_3);
		Assert.assertNotEquals(val1_3, val1_2);
		Assert.assertNotEquals(val1_3, testValue3_1);

		Assert.assertEquals(val1_3.toString(), "outer:1, inner:3");

		Set<JoinedValue<Integer, Integer>> set = new HashSet<>();
		set.add(val1_1);
		set.add(val1_2);
		set.add(val1_3);
		set.add(val2_1);
		set.add(val2_2);
		set.add(val2_3);
		Assert.assertTrue(set.contains(testValue1_3));
		Assert.assertFalse(set.contains(testValue3_1));
		Assert.assertFalse(set.contains(JoinedValue.create(null, null)));
	}
}
