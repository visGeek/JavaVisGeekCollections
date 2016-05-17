package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.functions.IndexedPredicate;
import com.github.visgeek.utils.functions.Predicate;

class LinqWhereIterator<T> extends Enumerator<T> {
	LinqWhereIterator(Iterable<T> source, Predicate<? super T> predicate) {
		this.predicate = (item, index) -> predicate.test(item);
		this.itr = source.iterator();
		this.indexEnabled = false;
	}

	LinqWhereIterator(Iterable<T> source, IndexedPredicate<? super T> predicate) {
		this.predicate = predicate;
		this.itr = source.iterator();
		this.indexEnabled = true;
	}

	private final IndexedPredicate<? super T> predicate;

	private final Iterator<T> itr;

	private final boolean indexEnabled;

	private int i = -1;

	private T current;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (this.itr.hasNext()) {
			if (this.indexEnabled) {
				this.i = Math.addExact(this.i, 1);
			}

			this.current = this.itr.next();
			if (this.predicate.test(this.current, this.i)) {
				result = true;
				break;
			}
		}

		return result;
	}
}
