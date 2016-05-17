package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.IndexedFunc1;

class LinqSelectIterator<T, TResult> extends AbstractConvertedIterator<T, TResult> {
	LinqSelectIterator(Iterable<T> source, Func1<? super T, TResult> selector) {
		super(source);
		this.selector = (item, index) -> selector.func(item);
		this.indexEnabled = false;
	}

	LinqSelectIterator(Iterable<T> source, IndexedFunc1<? super T, TResult> selector) {
		super(source);
		this.selector = selector;
		this.indexEnabled = true;
	}

	private final IndexedFunc1<? super T, TResult> selector;

	private final boolean indexEnabled;

	private int i = -1;

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	@Override
	public TResult next() {
		if (this.indexEnabled) {
			this.i = Math.addExact(this.i, 1);
		}

		return this.selector.func(this.iterator.next(), this.i);
	}
}
