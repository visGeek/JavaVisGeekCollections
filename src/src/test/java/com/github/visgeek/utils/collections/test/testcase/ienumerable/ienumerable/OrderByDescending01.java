package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.util.Collections;

import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.Tuple;
import com.github.visgeek.utils.testing.Tuple3;

public class OrderByDescending01 {
	@Test
	public void argIsNull() {
		EnumerableList<Integer> source = new EnumerableList<>();
		Func1<Integer, Integer> keySelector = null;
		Action0 action = () -> source.orderByDescending(keySelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void containsNull() {
		IEnumerable<String> source = () -> Enumerable.of("1", null, "2", null).iterator();
		IEnumerable<String> actual = source.orderByDescending(n -> n);
		Assert2.assertSequanceEquals(actual, "2", "1", null, null);
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
						.orderByDescending(val -> val.item2())
						.orderByDescending(val -> val.item3());

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 9, 6, 3, 8, 5, 2, 7, 4, 1);
	}
}
