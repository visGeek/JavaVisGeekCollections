package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Collections;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.Tuple;
import com.github.visgeek.utils.testing.Tuple3;

public class OrderBy {
	@Test
	public void test_orderBy01() {
		EnumerableList<Tuple3<Integer, Integer, Integer>> values = new EnumerableList<>();
		values.add(Tuple.create(1, 1, 1));
		values.add(Tuple.create(2, 1, 2));
		values.add(Tuple.create(3, 1, 3));
		values.add(Tuple.create(4, 2, 1));
		values.add(Tuple.create(5, 2, 2));
		values.add(Tuple.create(6, 2, 3));
		values.add(Tuple.create(7, 3, 1));
		values.add(Tuple.create(8, 3, 2));
		values.add(Tuple.create(9, 3, 3));

		Collections.shuffle(values);

		IEnumerable<Tuple3<Integer, Integer, Integer>> ordered =
				values
						.orderBy(val -> val.item2())
						.orderBy(val -> val.item3());

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 1, 4, 7, 2, 5, 8, 3, 6, 9);
	}

	@Test
	public void test_orderByDefaultKey01() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderByDefaultKey();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test_orderByDefaultKeyDesc01() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderByDefaultKeyDescending();
		Assert2.assertSequanceEquals(actual, 3, 2, 1);
	}

	@Test
	public void test_orderByDesc01() {
		EnumerableList<Tuple3<Integer, Integer, Integer>> values = new EnumerableList<>();
		values.add(Tuple.create(1, 1, 1));
		values.add(Tuple.create(2, 1, 2));
		values.add(Tuple.create(3, 1, 3));
		values.add(Tuple.create(4, 2, 1));
		values.add(Tuple.create(5, 2, 2));
		values.add(Tuple.create(6, 2, 3));
		values.add(Tuple.create(7, 3, 1));
		values.add(Tuple.create(8, 3, 2));
		values.add(Tuple.create(9, 3, 3));

		Collections.shuffle(values);

		IEnumerable<Tuple3<Integer, Integer, Integer>> ordered =
				values
						.orderByDescending(val -> val.item2())
						.orderByDescending(val -> val.item3());

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 9, 6, 3, 8, 5, 2, 7, 4, 1);
	}
}
