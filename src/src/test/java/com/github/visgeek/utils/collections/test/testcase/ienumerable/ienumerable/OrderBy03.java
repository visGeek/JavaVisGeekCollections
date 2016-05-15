package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.Tuple;
import com.github.visgeek.utils.testing.Tuple3;

public class OrderBy03 {
	@Test
	public void arg1IsNull() {
		EnumerableList<Integer> source = new EnumerableList<>();
		Comparator<Integer> comparator = null;

		Action0 action = () -> source.orderBy(comparator);

		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void test() {
		EnumerableList<Tuple3<Integer, Integer, Integer>> source = new EnumerableList<>();
		source.add(Tuple.create(1, 1, 1));
		source.add(Tuple.create(2, 1, 2));
		source.add(Tuple.create(3, 1, 3));
		source.add(Tuple.create(4, 2, 1));
		source.add(Tuple.create(5, 2, 2));
		source.add(Tuple.create(6, 2, 3));
		source.add(Tuple.create(7, 3, 1));
		source.add(Tuple.create(8, 3, 2));
		source.add(Tuple.create(9, 3, 3));

		Collections.shuffle(source);

		IEnumerable<Tuple3<Integer, Integer, Integer>> ordered =
				source
						.orderBy(this.comparator1)
						.orderBy(this.comparator2);

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 1, 4, 7, 2, 5, 8, 3, 6, 9);
	}

	private Comparator<Tuple3<Integer, Integer, Integer>> comparator1 = Comparator.comparing(tuple -> tuple.item2());

	private Comparator<Tuple3<Integer, Integer, Integer>> comparator2 = Comparator.comparing(tuple -> tuple.item3());
}
