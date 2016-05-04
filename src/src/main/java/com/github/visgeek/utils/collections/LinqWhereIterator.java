package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func2;

class LinqWhereIterator<T> extends AbstractEnumerator<T> {
	public LinqWhereIterator(Iterable<T> source, Func2<? super T, Integer, Boolean> predicate) {
		this.predicate = predicate;
		this.itr = source.iterator();
	}

	private final Func2<? super T, Integer, Boolean> predicate;

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
			if (this.predicate.func(this.current, this.i)) {
				result = true;
				break;
			}
		}

		return result;
	}
}
