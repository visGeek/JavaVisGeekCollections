package jp.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Set;

import jp.visgeek.utils.IEqualityComparator;

class LinqDistinctIterator<T> extends AbstractSimpleEnumerator<T, T> {
	public LinqDistinctIterator(Iterable<T> source, IEqualityComparator<? super T> comparator) {
		super(source);
		this.iterator = this.source.iterator();
		this.set = EquatableSet.create(comparator);
	}

	private final Iterator<T> iterator;

	private final Set<T> set;

	private T currentValue;

	@Override
	public boolean moveNext() {
		boolean result = false;

		while (this.iterator.hasNext()) {
			this.currentValue = this.iterator.next();
			if (this.set.add(this.currentValue)) {
				result = true;
				break;
			}
		}

		return result;
	}

	@Override
	public T current() {
		return this.currentValue;
	}
}
