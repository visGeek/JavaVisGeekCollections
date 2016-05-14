package com.github.visgeek.utils.collections.test.testcase.ireadonlylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.github.visgeek.utils.collections.IReadOnlyList;

@SuppressWarnings("unchecked")
class TestList<T> implements IReadOnlyList<T> {
	public TestList(T... values) {
		this.source = Arrays.asList(values);
	}

	private final List<T> source;

	@Override
	public T get(int index) {
		return this.source.get(index);
	}

	@Override
	public Iterator<T> iterator() {
		return this.source.iterator();
	}

	@Override
	public int size() {
		return this.source.size();
	}
}
