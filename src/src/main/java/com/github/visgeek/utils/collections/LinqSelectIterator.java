package com.github.visgeek.utils.collections;

import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.IndexedFunc1;

class LinqSelectIterator<T, TResult> extends AbstractConvertedIterator<T, TResult> {
	LinqSelectIterator(Iterable<T> source, Func1<? super T, TResult> selector) {
		this(source, (item, index) -> selector.func(item));
	}

	LinqSelectIterator(Iterable<T> source, IndexedFunc1<? super T, TResult> selector) {
		super(source);
		this.selector = selector;
	}

	private final IndexedFunc1<? super T, TResult> selector;

	private int i = -1;

	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	@Override
	public TResult next() {
		this.i++;
		return this.selector.func(this.iterator.next(), this.i);
	}
}
