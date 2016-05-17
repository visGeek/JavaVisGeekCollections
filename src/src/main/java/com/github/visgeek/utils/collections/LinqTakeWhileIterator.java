package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.functions.IndexedPredicate;
import com.github.visgeek.utils.functions.Predicate;

class LinqTakeWhileIterator<T> extends AbstractConvertedEnumerator<T, T> {
	LinqTakeWhileIterator(Iterable<T> source, Predicate<? super T> predicate) {
		super(source);
		this.predicate = (item, index) -> predicate.test(item);
		this.itr = this.source.iterator();
		this.indexEnabled = false;
	}

	LinqTakeWhileIterator(Iterable<T> source, IndexedPredicate<? super T> predicate) {
		super(source);
		this.predicate = predicate;
		this.itr = this.source.iterator();
		this.indexEnabled = true;
	}

	private final IndexedPredicate<? super T> predicate;

	private final Iterator<T> itr;

	private final boolean indexEnabled;

	private T current;

	private int index = -1;

	private boolean taking = true;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		if (this.taking) {
			if (this.itr.hasNext()) {
				if (this.indexEnabled) {
					this.index = Math.addExact(this.index, 1);
				}

				this.current = this.itr.next();

				if (this.predicate.test(this.current, this.index)) {
					result = true;
				} else {
					this.taking = false;
				}
			}
		}

		return result;
	}
}
