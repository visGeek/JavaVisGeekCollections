package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.functions.IndexedPredicate;

class LinqWhereIterator<T> extends Enumerator<T> {
	public LinqWhereIterator(Iterable<T> source, IndexedPredicate<? super T> predicate) {
		this.predicate = predicate;
		this.itr = source.iterator();
	}

	private final IndexedPredicate<? super T> predicate;

	private int i = -1;

	private final Iterator<T> itr;

	private T current;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (this.itr.hasNext()) {
			this.i++;
			this.current = this.itr.next();
			if (this.predicate.test(this.current, this.i)) {
				result = true;
				break;
			}
		}

		return result;
	}
}
