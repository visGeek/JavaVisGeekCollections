package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelist;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class Constructor {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void noArgs() {
		EnumerableList<Integer> actual = new EnumerableList<>(1, 2, 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void collectionNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Collection<Integer> collection = null;
		new EnumerableList<>(collection);
	}

	@Test
	public void collection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void iterableNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Iterable<Integer> collection = null;
		new EnumerableList<>(collection);
	}

	@Test
	public void iterable_Collection() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void iterable_Iterable() {
		Iterable<Integer> values = () -> Arrays.asList(1, 2, 3).iterator();
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void arrayNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("values");

		Integer[] collection = null;
		new EnumerableList<>(collection);
	}

	@Test
	public void array() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void capacity() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		EnumerableList<Integer> list = new EnumerableList<>(3);
		int actual = getCapacity(list);

		Assert.assertEquals(actual, 3);
	}

	static int getCapacity(ArrayList<?> list) {
		try {
			// リフレクションで無理矢理キャパシティを取得する。
			Field field = ArrayList.class.getDeclaredField("elementData");
			field.setAccessible(true);
			Object[] elementData = (Object[]) field.get(list);
			return elementData.length;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
