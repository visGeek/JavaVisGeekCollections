package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Max {
	@Test
	public void test_max01() {
		try {
			Enumerable.empty(Integer.class).max();
			Assert.fail();
		} catch (UnsupportedOperationException e) {
			//
		}
	}

	@Test
	public void test_max02() {
		int actual = Enumerable.of(1, 2, 3).max();
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_max03() {
		IEnumerable<MyClass> list = Enumerable.of(new MyClass(1), new MyClass(2), new MyClass(3));
		MyClass actual = list.max((a1, a2) -> a1.intValue - a2.intValue);
		Assert.assertEquals(3, actual.intValue);
	}

	@Test
	public void test_maxInt01() {
		IEnumerable<MyClass> list = Enumerable.of(new MyClass(1), new MyClass(2), new MyClass(3));
		int actual = list.maxInt(myClass -> myClass.intValue);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_maxDouble01() {
		IEnumerable<MyClass> values = Enumerable.of(new MyClass(1.0), new MyClass(2.0), new MyClass(3.0));
		double actual = values.maxDouble(myClass -> myClass.doubleValue);
		Assert.assertEquals(3.0, actual, 0.0);
	}

	private static class MyClass {
		public MyClass(int value) {
			this.intValue = value;
		}

		public MyClass(double value) {
			this.doubleValue = value;
		}

		public int intValue;

		public double doubleValue;
	}
}
