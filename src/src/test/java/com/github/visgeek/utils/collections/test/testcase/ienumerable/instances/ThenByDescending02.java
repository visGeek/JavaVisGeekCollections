package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.ComparatorUtils;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.Tuple;
import com.github.visgeek.utils.testing.Tuple3;

public class ThenByDescending02 {
	@Test
	public void argIsNull() {
		EnumerableList<Integer> source = new EnumerableList<>();
		Func1<Integer, Integer> keySelector = null;
		Comparator<Integer> comparator = ComparatorUtils.getDefault();

		Action0 action = () -> source.orderBy((a, b) -> 0).thenByDescending(keySelector, comparator);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void arg2IsNull() {
		EnumerableList<Integer> source = new EnumerableList<>();
		Func1<Integer, Integer> keySelector = n -> n;
		Comparator<Integer> comparator = null;

		Action0 action = () -> source.orderBy((a, b) -> 0).thenByDescending(keySelector, comparator);

		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void test() {
		EnumerableList<Tuple3<Integer, String, String>> source = new EnumerableList<>();
		source.add(Tuple.create(1, "#1", "#1"));
		source.add(Tuple.create(2, "$1", "$2"));
		source.add(Tuple.create(3, "%1", "%3"));
		source.add(Tuple.create(4, "&2", "&1"));
		source.add(Tuple.create(5, "'2", "'2"));
		source.add(Tuple.create(6, "(2", "&3"));
		source.add(Tuple.create(7, ")3", "'1"));
		source.add(Tuple.create(8, "#3", "(2"));
		source.add(Tuple.create(9, "$3", ")3"));

		Collections.shuffle(source);

		IEnumerable<Tuple3<Integer, String, String>> ordered =
				source
						.orderByDescending(val -> val.item3(), this.comparator)
						.thenByDescending(val -> val.item2(), this.comparator);

		IEnumerable<Integer> actual = ordered.select(val -> val.item1());

		Assert2.assertSequanceEquals(actual, 9, 6, 3, 8, 5, 2, 7, 4, 1);
	}

	private Comparator<String> comparator = Comparator.comparing(str -> str.substring(1));
}
