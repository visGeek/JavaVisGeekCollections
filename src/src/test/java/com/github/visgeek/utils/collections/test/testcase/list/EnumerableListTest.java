package com.github.visgeek.utils.collections.test.testcase.list;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.testing.Assert2;

public class EnumerableListTest {
	@Test
	public void ctorNoArgs() {
		EnumerableList<Integer> actual = new EnumerableList<>(1, 2, 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorCollection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorIterable_Collection() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorIterable_Iterable() {
		Iterable<Integer> values = () -> Arrays.asList(1, 2, 3).iterator();
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorArray() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		EnumerableList<Integer> actual = new EnumerableList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorCapacity() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		EnumerableList<Integer> list = new EnumerableList<>(3);
		int actual = getCapacity(list);

		Assert.assertEquals(actual, 3);
	}

	@Test
	public void clone01() {
		EnumerableList<Integer> list1 = new EnumerableList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		EnumerableList<Integer> list2 = list1.clone();

		Assert.assertNotSame(list1, list2);
		Assert2.assertSequanceEquals(list1, list2);

		list1.add(4);
		Assert.assertNotEquals(list1.size(), list2.size());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void contains() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);
		Assert.assertTrue(list.contains(1));
		Assert.assertFalse(list.contains(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void indexOf() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3, 2);
		Assert.assertEquals(1, list.indexOf(2));
		Assert.assertEquals(-1, list.indexOf(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void lastIndexOf() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3, 2);
		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeIndex() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);

		{
			int index = 1;
			int expected = 2;
			Integer actual = list.remove(index);
			Assert.assertEquals(expected, (int) actual);
		}

		{
			int index = 0;
			int expected = 1;
			Integer actual = list.remove(index);
			Assert.assertEquals(expected, (int) actual);
		}
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeObject() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);
		Integer target = 2;
		boolean actual = list.remove(target);
		Assert.assertTrue(actual);
		Assert2.assertSequanceEquals(list, 1, 3);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeAllCollection() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3, 2, 4);
		Collection<Integer> targetCollection = Arrays.asList(2, 3);
		list.removeAll(targetCollection);
		Assert2.assertSequanceEquals(list, 1, 4);
	}

	@Test
	public void toString01() {
		EnumerableList<Integer> list = new EnumerableList<>(1, 2, 3);
		Assert.assertEquals("size:3", list.toString());
	}

	@Test
	public void create01() {
		EnumerableList<Integer> list = EnumerableList.create(Arrays.asList(1, 2, 3));
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}

	@Test
	public void create02() {
		EnumerableList<Integer> list = EnumerableList.create(1, 2, 3);
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}

	@Test
	public void getEmptyReadOnlyList() {
		IReadOnlyList<Integer> list = EnumerableList.getEmptyReadOnlyList();
		Assert.assertTrue(list.isEmpty());
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
