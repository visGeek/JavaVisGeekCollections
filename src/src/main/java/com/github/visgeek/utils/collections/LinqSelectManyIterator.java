package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IndexedFunc1;

class LinqSelectManyIterator<T, TResult> extends AbstractConvertedEnumerator<T, TResult> {
	public LinqSelectManyIterator(Iterable<T> source, IndexedFunc1<? super T, Iterable<TResult>> selector) {
		super(source);
		this.selector = selector;
		this.i = -1;
		this.iterator = this.source.iterator();
		this.itr = null;
	}

	private final IndexedFunc1<? super T, Iterable<TResult>> selector;

	private int i;

	private final Iterator<T> iterator;

	private Iterator<TResult> itr;

	private TResult current;

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (true) {
			if (this.itr != null && this.itr.hasNext()) {
				this.current = this.itr.next();
				result = true;
				break;

			} else if (this.iterator.hasNext()) {
				this.i++;
				this.itr = this.selector.func(this.iterator.next(), this.i).iterator();

			} else {
				break;
			}
		}

		return result;
	}

	@Override
	public TResult current() {
		return this.current;
	}
}
