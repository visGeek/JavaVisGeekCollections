package jp.visgeek.utils.collections;

import java.util.Iterator;

import jp.visgeek.utils.Func2;

class LinqTakeWhileIterator<T> extends AbstractSimpleEnumerator<T, T> {
	public LinqTakeWhileIterator(Iterable<T> source, Func2<? super T, Integer, Boolean> predicate) {
		super(source);
		this.predicate = predicate;
		this.itr = this.source.iterator();
	}

	private final Func2<? super T, Integer, Boolean> predicate;

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

		if (this.taking && this.itr.hasNext()) {
			this.current = this.itr.next();
			this.index++;
			if (this.predicate.func(this.current, this.index)) {
				result = true;
			} else {
				this.taking = false;
			}
		}

		return result;
	}
}