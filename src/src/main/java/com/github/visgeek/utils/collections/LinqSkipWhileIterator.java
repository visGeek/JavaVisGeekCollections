package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func2;

class LinqSkipWhileIterator<T> extends AbstractSimpleEnumerator<T, T> {
	public LinqSkipWhileIterator(Iterable<T> source, Func2<? super T, Integer, Boolean> predicate) {
		super(source);
		this.predicate = predicate;
		this.itr = source.iterator();
	}

	private final Func2<? super T, Integer, Boolean> predicate;

	private final Iterator<T> itr;

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
			this.current = this.itr.next();
			this.index++;

			if (this.skiped) {
				result = true;
				break;
			} else if (!this.predicate.func(this.current, this.index)) {
				this.skiped = true;
				result = true;
				break;
			}
		}

		return result;
	}
}
