package com.github.visgeek.utils.collections.test.testcase.list;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.testing.Assert2;

public class EnumerableLinkedListTest {
	@Test
	public void ctorNoArgs() {
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(1, 2, 3);
		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorCollection() {
		Collection<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorIterable_Collection() {
		Iterable<Integer> values = Arrays.asList(1, 2, 3);
		EnumerableLinkedList<Integer> actual = new EnumerableLinkedList<>(values);

		Assert2.assertSequanceEquals(actual, 1, 2, 3);
	}

	@Test
	public void ctorIterable_Iterable() {
		Iterable<Integer> values = () -> Arrays.asList(1, 2, 3).iterator();
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
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
		Assert.assertTrue(list.contains(1));
		Assert.assertFalse(list.contains(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void indexOf() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2);
		Assert.assertEquals(1, list.indexOf(2));
		Assert.assertEquals(-1, list.indexOf(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void lastIndexOf() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2);
		Assert.assertEquals(3, list.lastIndexOf(2));
		Assert.assertEquals(-1, list.lastIndexOf(4));
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeIndex() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);

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
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
		Integer target = 2;
		boolean actual = list.remove(target);
		Assert.assertTrue(actual);
		Assert2.assertSequanceEquals(list, 1, 3);
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeAllCollection() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2, 4);
		Collection<Integer> targetCollection = Arrays.asList(2, 3);
		list.removeAll(targetCollection);
		Assert2.assertSequanceEquals(list, 1, 4);
	}

	@Test
	public void toString01() {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3);
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

	@Test
	@SuppressWarnings("deprecation")
	public void removeFirstOccurrence() {
		this.removeFirstOccurrenceInternal((list, target) -> list.removeFirstOccurrence(target));
	}

	@Test
	public void removeFirstOccurredValue() {
		this.removeFirstOccurrenceInternal((list, target) -> list.removeFirstOccurredValue(target));
	}

	private void removeFirstOccurrenceInternal(Func2<EnumerableLinkedList<Integer>, Integer, Boolean> method) {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2);

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertTrue(result);
			Assert2.assertSequanceEquals(list, 1, 3, 2);
		}

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertTrue(result);
			Assert2.assertSequanceEquals(list, 1, 3);
		}

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertFalse(result);
			Assert2.assertSequanceEquals(list, 1, 3);
		}
	}

	@Test
	@SuppressWarnings("deprecation")
	public void removeLastOccurrence() {
		this.removeLastOccurrenceInternal((list, target) -> list.removeLastOccurrence(target));
	}

	@Test
	public void removeLastOccurredValue() {
		this.removeLastOccurrenceInternal((list, target) -> list.removeLastOccurredValue(target));
	}

	public void removeLastOccurrenceInternal(Func2<EnumerableLinkedList<Integer>, Integer, Boolean> method) {
		EnumerableLinkedList<Integer> list = new EnumerableLinkedList<>(1, 2, 3, 2);

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertTrue(result);
			Assert2.assertSequanceEquals(list, 1, 2, 3);
		}

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertTrue(result);
			Assert2.assertSequanceEquals(list, 1, 3);
		}

		{
			Integer target = 2;
			boolean result = method.func(list, target);
			Assert.assertFalse(result);
			Assert2.assertSequanceEquals(list, 1, 3);
		}
	}
}
