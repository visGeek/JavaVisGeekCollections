package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;

public class Min {
	@Test
	public void test_min01() {
		try {
			Enumerable.empty(Integer.class).min();
			Assert.fail();
		} catch (UnsupportedOperationException e) {
			//
		}
	}

	@Test
	public void test_min02() {
		int actual = Enumerable.of(1, 2, 3).min();
		Assert.assertEquals(1, actual);
	}

	@Test
	public void test_min03() {
		IEnumerable<MyClass> list = Enumerable.of(new MyClass(1), new MyClass(2), new MyClass(3));
		MyClass actual = list.min((a1, a2) -> a1.intValue - a2.intValue);
		Assert.assertEquals(1, actual.intValue);
	}

	@Test
	public void test_minInt01() {
		int actual = Enumerable.of(new MyClass(1), new MyClass(2), new MyClass(3)).minInt(myClass -> myClass.intValue);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void test_minDouble01() {
		double actual = Enumerable.of(new MyClass(1.0), new MyClass(2.0), new MyClass(3.0)).minDouble(myClass -> myClass.doubleValue);
		Assert.assertEquals(1.0, actual, 0.0);
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
