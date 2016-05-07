package com.github.visgeek.utils.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.github.visgeek.utils.ComparatorUtils;
import com.github.visgeek.utils.testing.Activator;
import com.github.visgeek.utils.testing.Assert2;

public class ComparatorUtilsTest {
	public ComparatorUtilsTest() {
		Activator.create(ComparatorUtils.class);
	}

	@Test
	public void getDefault() {
		Comparator<Integer> comparator = ComparatorUtils.getDefault();
		List<Integer> values = new ArrayList<>();
		values.add(5);
		values.add(3);
		values.add(1);
		values.add(null);
		values.add(2);
		values.add(4);

		values.sort(comparator);

		Assert2.assertSequanceEquals(values, null, 1, 2, 3, 4, 5);
	}

	@Test
	public void create01FromOrders01() {
		Integer[] orders = new Integer[] { 5, 3, 1, 2, 4 };
		Comparator<Integer> comparator = ComparatorUtils.createFromOrders(orders);
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(6);
		values.add(null);

		values.sort(comparator);

		Assert2.assertSequanceEquals(values, 6, null, 5, 3, 1, 2, 4);
	}

	@Test
	public void create01FromOrders02() {
		Iterable<Integer> orders = Arrays.asList(5, 3, 1, 2, 4);
		Comparator<Integer> comparator = ComparatorUtils.createFromOrders(orders);
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		values.add(3);
		values.add(4);
		values.add(5);
		values.add(6);
		values.add(null);

		values.sort(comparator);

		Assert2.assertSequanceEquals(values, 6, null, 5, 3, 1, 2, 4);
	}
}
