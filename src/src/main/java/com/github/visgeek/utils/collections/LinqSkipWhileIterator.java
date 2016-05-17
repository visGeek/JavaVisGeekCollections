package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.functions.IndexedPredicate;
import com.github.visgeek.utils.functions.Predicate;

class LinqSkipWhileIterator<T> extends AbstractConvertedEnumerator<T, T> {
	LinqSkipWhileIterator(Iterable<T> source, Predicate<? super T> predicate) {
		super(source);
		this.predicate = (item, index) -> predicate.test(item);
		this.itr = source.iterator();
		this.indexEnabled = false;
	}

	LinqSkipWhileIterator(Iterable<T> source, IndexedPredicate<? super T> predicate) {
		super(source);
		this.predicate = predicate;
		this.itr = source.iterator();
		this.indexEnabled = true;
	}

	private final IndexedPredicate<? super T> predicate;

	private final Iterator<T> itr;

	private final boolean indexEnabled;

	private T current;

	private int index = -1;

	private boolean skiped = false;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (this.itr.hasNext()) {
			if (this.indexEnabled) {
				this.index = Math.addExact(this.index, 1);
			}

			this.current = this.itr.next();

			if (this.skiped) {
				result = true;
				break;
			} else if (!this.predicate.test(this.current, this.index)) {
				this.skiped = true;
				result = true;
				break;
			}
		}

		return result;
	}
}
