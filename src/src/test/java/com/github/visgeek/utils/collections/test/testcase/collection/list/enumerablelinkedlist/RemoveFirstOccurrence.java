package com.github.visgeek.utils.collections.test.testcase.collection.list.enumerablelinkedlist;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedList;
import com.github.visgeek.utils.functions.Func2;
import com.github.visgeek.utils.testing.Assert2;

public class RemoveFirstOccurrence {
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
}
