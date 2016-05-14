package com.github.visgeek.utils.collections.test.testcase.ireadonlycollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.github.visgeek.utils.collections.IReadOnlyCollection;

@SuppressWarnings("unchecked")
class TestCollection<T> implements IReadOnlyCollection<T> {
	public TestCollection(T... values) {
		this.source = Arrays.asList(values);
	}

	private final List<T> source;

	@Override
	public Iterator<T> iterator() {
		return this.source.iterator();
	}

	@Override
	public int size() {
		return this.source.size();
	}
}
