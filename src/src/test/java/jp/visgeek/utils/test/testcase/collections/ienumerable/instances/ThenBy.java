package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import java.util.Collections;

import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.EnumerableList;
import jp.visgeek.utils.collections.IEnumerable;
import jp.visgeek.utils.testing.Assert2;
import jp.visgeek.utils.testing.Tuple;
import jp.visgeek.utils.testing.Tuple3;

public class ThenBy {
	@Test
	public void test_thenBy01() {
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
						.thenBy(val -> val.item3());

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}

	@Test
	public void test_thenByDefaultKey01() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderByDefaultKey().thenByDefaultKey();
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void test_thenByDefaultKeyDesc01() {
		IEnumerable<Integer> actual = Enumerable.of(3, 1, 2).orderByDefaultKeyDescending().thenByDefaultKeyDescending();
		Assert2.assertSequanceEquals(actual, 3, 2, 1);
	}

	@Test
	public void test_thenByDesc01() {
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
						.thenByDescending(val -> val.item3());

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 9, 8, 7, 6, 5, 4, 3, 2, 1);
	}
}
