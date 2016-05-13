package com.github.visgeek.utils.collections.test.testcase.ienumerable;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IReadOnlyList;
import com.github.visgeek.utils.testing.Assert2;

public class GroupBy07 {
	@Test
	public void arg1IsNull() {
		Func1<Entry, String> keySelector = null;
		Func1<Entry, Element> elementSelector = ety -> new Element(ety);
		Func2<String, IEnumerable<Element>, Group> resultSelector = (key, entries) -> new Group(key, entries);
		Action0 action = () -> Enumerable.empty(Entry.class).groupBy(keySelector, elementSelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
	}

	@Test
	public void arg2IsNull() {
		Func1<Entry, String> keySelector = ety -> ety.key;
		Func1<Entry, Element> elementSelector = null;
		Func2<String, IEnumerable<Element>, Group> resultSelector = (key, entries) -> new Group(key, entries);
		Action0 action = () -> Enumerable.empty(Entry.class).groupBy(keySelector, elementSelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("elementSelector", action);
	}

	@Test
	public void arg3IsNull() {
		Func1<Entry, String> keySelector = ety -> ety.key;
		Func1<Entry, Element> elementSelector = ety -> new Element(ety);
		Func2<String, IEnumerable<Element>, Group> resultSelector = null;
		Action0 action = () -> Enumerable.empty(Entry.class).groupBy(keySelector, elementSelector, resultSelector);
		Assert2.assertNullPointerExceptionThrown("resultSelector", action);
	}

	@Test
	public void test01() {
		Entry[] source =
				new Entry[] {
					new Entry("a", 1),
					new Entry("b", 1),
					new Entry("c", 1),
					new Entry("a", 2),
					new Entry("c", 2),
					new Entry("a", 3),
					new Entry("d", 1),
				};

		Func1<Entry, Element> elementSelector = ety -> new Element(ety);
		Func2<String, IEnumerable<Element>, Group> resultSelector = (key, entries) -> new Group(key, entries);

		IEnumerable<Group> groups =
				Enumerable
						.of(source)
						.groupBy(ety -> ety.key, elementSelector, resultSelector);

		IReadOnlyList<Group> groupList = groups.toList();

		Assert.assertEquals(4, groupList.size());

		assertEquals(groupList.get(0), "a", 1, 2, 3);
		assertEquals(groupList.get(1), "b", 1);
		assertEquals(groupList.get(2), "c", 1, 2);
		assertEquals(groupList.get(3), "d", 1);
	}

	private void assertEquals(Group group, String key, Integer... values) {
		Assert.assertEquals(key, group.key);
		Assert2.assertSequanceEquals(group.entries.select(element -> element.ety.value), values);
	}

	private static class Entry {
		public Entry(String key, int value) {
			this.key = key;
			this.value = value;
		}

		final String key;

		final int value;
	}

	private static class Element {
		public Element(Entry ety) {
			this.ety = ety;
		}

		final Entry ety;
	}

	private static class Group {
		public Group(String key, IEnumerable<Element> entries) {
			this.key = key;
			this.entries = entries;
		}

		final String key;

		final IEnumerable<Element> entries;
	}
}
