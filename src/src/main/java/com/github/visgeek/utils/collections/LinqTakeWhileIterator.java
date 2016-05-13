package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IndexedPredicate;

class LinqTakeWhileIterator<T> extends AbstractConvertedEnumerator<T, T> {
	public LinqTakeWhileIterator(Iterable<T> source, IndexedPredicate<? super T> predicate) {
		super(source);
		this.predicate = predicate;
		this.itr = this.source.iterator();
	}

	private final IndexedPredicate<? super T> predicate;

	private final Iterator<T> itr;

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
				this.current = this.itr.next();
				this.index++;
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
