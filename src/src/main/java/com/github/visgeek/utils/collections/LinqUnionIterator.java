package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IEqualityComparator;

class LinqUnionIterator<T> extends AbstractEnumerator<T> {
	public LinqUnionIterator(Iterable<T> source, Iterable<? extends T> second, IEqualityComparator<? super T> comparator) {
		this.second = second;
		this.set = EquatableSet.create(comparator);
		this.itr = source.iterator();
	}

	private final Iterable<? extends T> second;

	private Iterator<? extends T> itr;

	private final EquatableSet<T> set;

	private boolean isSwitched = false;

	private T currentValue;

	@Override
	public T current() {
		return this.currentValue;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (this.itr.hasNext()) {
			this.currentValue = this.itr.next();
			if (this.set.add(this.currentValue)) {
				result = true;
				break;
			}
		}

		if (result == false && !this.isSwitched) {
			this.itr = this.second.iterator();
			this.isSwitched = true;
			result = this.moveNext();
		}

		return result;
	}
}
