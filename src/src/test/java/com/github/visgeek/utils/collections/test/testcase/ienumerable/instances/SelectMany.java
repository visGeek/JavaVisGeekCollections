package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;

public class SelectMany {
	@Test
	public void test_selectMany01() {
		IEnumerable<Integer> actual =
				Enumerable
						.of(new MyClass(1, 2), new MyClass((Integer[]) null), new MyClass(3, 4))
						.selectMany(myClass -> myClass.values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4);
	}

	@Test
	public void test_selectMany02() {
		IEnumerable<String> actual =
				Enumerable
						.of(new MyClass(1, 2), new MyClass((Integer[]) null), new MyClass(3, 4))
						.selectMany(myClass -> myClass.values)
						.select((n, index) -> String.format("%d:%dm", index, n));

		Assert2.assertSequanceEquals(actual, "0:1m", "1:2m", "2:3m", "3:4m");
	}

	@Test
	public void test_selectMany03() {
		IEnumerable<String> actual =
				Enumerable.empty(MyClass.class)
						.selectMany(myClass -> myClass.values)
						.select((n, index) -> String.format("%d:%dm", index, n));

		Assert2.assertSequanceEquals(actual);
	}

	private static class MyClass {
		public MyClass(Integer... values) {
			if (values == null) {
				this.values = new ArrayList<>();
			} else {
				this.values = Arrays.asList(values);
			}
		}

		public Iterable<Integer> values;
	}
}
