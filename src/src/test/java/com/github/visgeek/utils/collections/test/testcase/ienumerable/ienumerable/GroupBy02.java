package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.IEqualityComparator;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IGrouping;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.testing.Assert2;

public class GroupBy02 {
	@Test
	public void arg1IsNull() {
		Func1<Entry, String> keySelector = null;
		IEqualityComparator<String> comparator = IEqualityComparator.create((String str) -> str.substring(1));
		Action0 action = () -> Enumerable.empty(Entry.class).groupBy(keySelector, comparator);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void arg2IsNull() {
		Func1<Entry, String> keySelector = ety -> ety.key;
		IEqualityComparator<String> comparator = null;
		Action0 action = () -> Enumerable.empty(Entry.class).groupBy(keySelector, comparator);
		Assert2.assertExceptionNotThrown(action);
	}

	@Test
	public void test01() {
		Entry[] source =
				new Entry[] {
					new Entry("!a", 1),
					new Entry("!b", 1),
					new Entry("!c", 1),
					new Entry("#a", 2),
					new Entry("&c", 2),
					new Entry("$a", 3),
					new Entry("!d", 1),
				};

		IEqualityComparator<String> comparator = IEqualityComparator.create((String str) -> str.substring(1));

		IEnumerable<IGrouping<String, Entry>> groups =
				Enumerable
						.of(source)
						.groupBy(ety -> ety.key, comparator);

		IReadOnlyList<IGrouping<String, Entry>> groupList = groups.toList();

		Assert.assertEquals(4, groupList.size());

		this.assertEquals(groupList.get(0), "!a", 1, 2, 3);
		this.assertEquals(groupList.get(1), "!b", 1);
		this.assertEquals(groupList.get(2), "!c", 1, 2);
		this.assertEquals(groupList.get(3), "!d", 1);
	}

	private void assertEquals(IGrouping<String, Entry> group, String key, Integer... values) {
		Assert.assertEquals(key, group.key());
		Assert2.assertSequanceEquals(group.select(ety -> ety.value), values);
	}

	private static class Entry {
		public Entry(String key, int value) {
			this.key = key;
			this.value = value;
		}

		final String key;

		final int value;
	}
}
