package com.github.visgeek.utils.collections;

import java.util.Iterator;

abstract class ArrayEnumerable<T> implements IListEnumerable<T> {
	@Override
	public final Iterator<T> iterator() {
		return Enumerable.range(0, this.count()).select(idx -> this.elementAt(idx)).iterator();
	}
}
