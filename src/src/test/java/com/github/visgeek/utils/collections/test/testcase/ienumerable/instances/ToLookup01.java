package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.Action0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.Enumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.ILookup;
import com.github.visgeek.utils.testing.Assert2;

public class ToLookup01 {
	@Test
	public void arg1IsNull() {
		Func1<Entry, String> keySelector = null;
		Action0 action = () -> Enumerable.empty(Entry.class).toLookup(keySelector);
		Assert2.assertNullPointerExceptionThrown("keySelector", action);
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

		ILookup<String, Entry> lookup =
				Enumerable
						.of(source)
						.toLookup(ety -> ety.key);

		IEnumerable<String> keys = lookup.select(group -> group.key()).orderByDefaultKey();
		Assert2.assertSequanceEquals(keys, "a", "b", "c", "d");

		Assert.assertEquals(4, lookup.count());

		this.assertEquals(lookup, "a", true, 1, 2, 3);
		this.assertEquals(lookup, "b", true, 1);
		this.assertEquals(lookup, "c", true, 1, 2);
		this.assertEquals(lookup, "d", true, 1);
		this.assertEquals(lookup, "_", false);
	}

	private void assertEquals(ILookup<String, Entry> lookup, String key, boolean containsKey, Integer... values) {
		Assert.assertEquals(containsKey, lookup.containsKey(key));
		IEnumerable<Entry> group = lookup.get(key);
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
