package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IEqualityComparator;

class LinqExceptIterator<T> extends Enumerator<T> {
	public LinqExceptIterator(Iterable<T> source, Iterable<? extends T> second, IEqualityComparator<? super T> comparator) {
		this.source = source;
		this.second = second;
		this.set = EquatableSet.create(comparator);
	}

	private final Iterable<T> source;

	private final Iterable<? extends T> second;

	private final EquatableSet<T> set;

	private Iterator<T> itr;

	private T currentValue;

	@Override
	public boolean moveNext() {
		if (this.itr == null) {
			this.itr = source.iterator();
			for (T item : second) {
				this.set.add(item);
			}
		}

		boolean result = false;

		while (this.itr.hasNext()) {
			this.currentValue = this.itr.next();

			if (this.set.add(this.currentValue)) {
				result = true;
				break;
			}
		}

		return result;
	}

	@Override
	public T current() {
		return this.currentValue;
	}
}
