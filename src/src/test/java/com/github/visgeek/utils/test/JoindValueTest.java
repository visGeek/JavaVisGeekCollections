package com.github.visgeek.utils.test;

import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.JoinedValue;

public class JoindValueTest {
	@Test
	public void outer() {
		JoinedValue<Integer, Integer> val = JoinedValue.create(1, 2);
		Assert.assertEquals(val.outer(), Integer.valueOf(1));
	}

	@Test
	public void inner() {
		JoinedValue<Integer, Integer> val = JoinedValue.create(1, 2);
		Assert.assertEquals(val.inner(), Integer.valueOf(2));
	}

	@Test
	public void equlaseObject() {
		JoinedValue<Integer, Integer> val1 = JoinedValue.create(1, 2);
		JoinedValue<Integer, Integer> val2 = JoinedValue.create(1, 2);
		JoinedValue<Integer, Integer> val3 = JoinedValue.create(1, 3);
		Assert.assertEquals(val1, val2);
		Assert.assertNotEquals(val1, val3);
		Assert.assertNotEquals(val1, "str");
		Assert.assertNotEquals(val1, null);
	}

	@Test
	public void equlaseJoinedValue() {
		JoinedValue<Integer, Integer> val1 = JoinedValue.create(1, 2);
		JoinedValue<Integer, Integer> val2 = JoinedValue.create(1, 2);
		JoinedValue<Integer, Integer> val3 = JoinedValue.create(1, 3);
		Assert.assertTrue(val1.equals(val2));
		Assert.assertFalse(val1.equals(val3));
		Assert.assertFalse(val1.equals((JoinedValue<Integer, Integer>) null));
	}

	@Test
	public void equlaseJoinedValueMembers() {
		JoinedValue<Integer, Integer> val = JoinedValue.create(1, 2);
		Assert.assertFalse(val.equals(0, 2));
		Assert.assertTrue(val.equals(1, 2));
		Assert.assertFalse(val.equals(1, 3));
	}

	@Test
	public void hashCode01() {
		this.hashCodeInternal(1, 2);
		this.hashCodeInternal("1", 2);
		this.hashCodeInternal(null, 1);
		this.hashCodeInternal(null, null);
		this.hashCodeInternal("1", null);
	}

	public <T1, T2> void hashCodeInternal(T1 a, T2 b) {
		JoinedValue<T1, T2> val = JoinedValue.create(a, b);
		Assert.assertEquals(String.format("a:%s b:%s", a, b), val.hashCode(), Objects.hash(a, b));
	}

	@Test
	public void toString01() {
		JoinedValue<Integer, Integer> val1 = JoinedValue.create(1, 2);
		Assert.assertEquals(val1.toString(), "outer:1, inner:2");

		JoinedValue<String, String> val2 = JoinedValue.create("1", "2");
		Assert.assertEquals(val2.toString(), "outer:1, inner:2");

		JoinedValue<String, String> val3 = JoinedValue.create(null, null);
		Assert.assertEquals(val3.toString(), "outer:null, inner:null");
	}
}
