package jp.visgeek.utils.collections;

import java.util.Iterator;

class LinqShiftIterator<T> extends AbstractSimpleEnumerator<T, T> {
	public LinqShiftIterator(Iterable<T> source, int count) {
		super(source);
		this.count = count;
		this.itr = this.source.iterator();
	}

	private final int count;

	private Iterator<T> itr;

	private T current;

	private EnumerableList<T> cache = new EnumerableList<>();

	private boolean isFirst = true;

	private boolean flag = false;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		boolean result = false;

		if (this.isFirst) {
			if (this.count < 0) {
				int i = 0;
				while (this.itr.hasNext()) {
					i++;
					this.cache.add(this.itr.next());
				}
				int n = i + (this.count % i);
				this.itr = new LinqShiftIterator<>(this.cache, n);
				this.flag = true;

			} else if (0 < this.count) {
				int i;
				for (i = 0; i < this.count; i++) {
					if (this.itr.hasNext()) {
						this.cache.add(this.itr.next());
					} else if (i != 0) {
						int n = this.count % i;
						this.itr = new LinqShiftIterator<>(this.cache, n);
						this.flag = true;
						break;
					}
				}
			}

			this.isFirst = false;
		}

		if (this.itr.hasNext()) {
			result = true;
			this.current = this.itr.next();
		} else if (!this.flag) {
			this.flag = true;
			this.itr = this.cache.iterator();
			if (this.itr.hasNext()) {
				result = true;
				this.current = this.itr.next();
			}
		}

		return result;
	}
}
