package com.github.visgeek.utils.collections.test.testcase;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.testing.Assert2;

public class EnumerableLinkedListTest {
	@Test
	public void ctorNoArgs() {
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>();
		actual.add(1);
		actual.add(2);
		actual.add(3);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorCollection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorIterable() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorArray() {
		Integer[] values = new Integer[] { 1, 2, 3 };
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void addAll01() {
		Collection<Integer> valuesCollectionCollection = Arrays.asList(1, 2, 3);
		Iterable<Integer> valuesIterableCollection = valuesCollectionCollection;
		Iterable<Integer> valuesIterableIterable = () -> valuesCollectionCollection.iterator();

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		EnumerableLinkedList<Integer> list2 = new EnumerableLinkedList<>();
		EnumerableLinkedList<Integer> list3 = new EnumerableLinkedList<>();

		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.addAll(valuesCollectionCollection);
			boolean result2 = list2.addAll(valuesIterableCollection);
			boolean result3 = list3.addAll(valuesIterableIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result1, result2);
			Assert.assertEquals(message, result1, result3);

			Assert2.assertSequanceEquals(message, list2, list1);
			Assert2.assertSequanceEquals(message, list3, list1);
		}
	}

	@Test
	public void addAll02() {
		Collection<Integer> valuesCollectionCollection = Arrays.asList(2, 3, 4);
		Iterable<Integer> valuesIterableCollection = valuesCollectionCollection;
		Iterable<Integer> valuesIterableIterable = () -> valuesCollectionCollection.iterator();

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>(1, 5);
		EnumerableLinkedList<Integer> list2 = list1.clone();
		EnumerableLinkedList<Integer> list3 = list1.clone();

		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.addAll(2, valuesCollectionCollection);
			boolean result2 = list2.addAll(2, valuesIterableCollection);
			boolean result3 = list3.addAll(2, valuesIterableIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result1, result2);
			Assert.assertEquals(message, result1, result3);

			Assert2.assertSequanceEquals(message, list2, list1);
			Assert2.assertSequanceEquals(message, list3, list1);
		}
	}

	@Test
	public void any() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>();
		Assert.assertFalse(list.any());

		list.add(1);
		Assert.assertTrue(list.any());
	}

	@Test
	public void clone01() {
		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		EnumerableLinkedList<Integer> list2 = list1.clone();

		Assert.assertNotSame(list1, list2);
		Assert2.assertSequanceEquals(list1, list2);

		list1.add(4);
		Assert.assertNotEquals(list1.size(), list2.size());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void contains() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		Assert.assertTrue(list.contains(1));
		Assert.assertFalse(list.contains(4));
		Assert.assertTrue(list.containsValue(1));
		Assert.assertFalse(list.containsValue(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void indexOf() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);

		Assert.assertEquals(1, list.indexOf(2));
		Assert.assertEquals(-1, list.indexOf(4));
		Assert.assertEquals(list.indexOf(2), list.indexOfValue(2));
		Assert.assertEquals(list.indexOf(4), list.indexOfValue(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void lastIndexOf() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(2);

		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
		Assert.assertEquals(list.lastIndexOf(2), list.lastIndexOfValue(2));
		Assert.assertEquals(list.lastIndexOf(4), list.lastIndexOfValue(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeIndex_removeAt() {
		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);

		EnumerableLinkedList<Integer> list2 = list1.clone();

		int index = 1;
		Integer result1 = list1.remove(index);
		Integer result2 = list2.removeAt(index);

		Assert.assertEquals(Integer.valueOf(2), result1);
		Assert.assertEquals(result1, result2);
		Assert2.assertSequanceEquals(list1, list2);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeObject_removeValue() {
		int target = 2;

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(target - 1);
		list1.add(target);
		list1.add(target + 1);
		list1.add(target);

		EnumerableLinkedList<Integer> list2 = list1.clone();

		// target をすべて消して更にもう一回試みる。
		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.remove(Integer.valueOf(target));
			boolean result2 = list2.removeValue(target);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result1, result2);
			Assert2.assertSequanceEquals(message, list1, list2);
		}
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeFirstOccurrence() {
		int target = 2;

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(target - 1);
		list1.add(target);
		list1.add(target + 1);
		list1.add(target);

		EnumerableLinkedList<Integer> list2 = list1.clone();

		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.removeFirstOccurrence(target);
			boolean result2 = list2.removeFirstOccurredValue(target);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result2, result1);
			Assert2.assertSequanceEquals(message, list2, list1);
		}
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeLastOccurrence() {
		int target = 2;

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(target - 1);
		list1.add(target);
		list1.add(target + 1);
		list1.add(target);

		EnumerableLinkedList<Integer> list2 = list1.clone();

		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.removeLastOccurrence(target);
			boolean result2 = list2.removeLastOccurredValue(target);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result2, result1);
			Assert2.assertSequanceEquals(message, list2, list1);
		}
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeAllCollection() {
		Collection<Integer> targetCollection = Arrays.asList(2, 3);
		Iterable<Integer> targetIterable = () -> targetCollection.iterator();

		EnumerableLinkedList<Integer> list1 = new EnumerableLinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(2);
		list1.add(4);

		EnumerableLinkedList<Integer> list2 = list1.clone();
		EnumerableLinkedList<Integer> list3 = list1.clone();

		// target をすべて消して更にもう一回試みる。
		for (int i = 1; i <= 3; i++) {
			boolean result1 = list1.removeAll(targetCollection);
			boolean result2 = list2.removeAllValues(targetCollection);
			boolean result3 = list3.removeAllValues(targetIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, result2, result1);
			Assert.assertEquals(message, result3, result1);

			Assert2.assertSequanceEquals(message, list2, list1);
			Assert2.assertSequanceEquals(message, list3, list1);
		}
	}

	@Test
	public void toString01() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);

		Assert.assertEquals("size:3", list.toString());
	}

	@Test
	public void create01() {
		EnumerableLinkedList<Integer> list = EnumerableLinkedList.create(Arrays.asList(1, 2, 3));
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}

	@Test
	public void create02() {
		EnumerableLinkedList<Integer> list = EnumerableLinkedList.create(1, 2, 3);
		Assert2.assertSequanceEquals(list, 1, 2, 3);
	}

	@Test
	public void getEmptyReadOnlyList() {
		IReadOnlyList<Integer> list = EnumerableLinkedList.getEmptyReadOnlyList();
		Assert.assertTrue(list.isEmpty());
	}
}
