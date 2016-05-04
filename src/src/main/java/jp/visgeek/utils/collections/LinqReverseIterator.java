package jp.visgeek.utils.collections;

class LinqReverseIterator<T> extends AbstractSimpleEnumerator<T, T> {
	public LinqReverseIterator(Iterable<T> source) {
		super(source);
	}

	private EnumerableList<T> list = null;

	private int index = -1;

	private T current;

	@Override
	public T current() {
		return this.current;
	}

	@Override
	public boolean moveNext() {
		if (this.list == null) {
			this.list = new EnumerableList<T>(this.source);
			this.index = list.size();
		}

		boolean result = false;

		this.index--;
		if (0 <= this.index) {
			this.current = this.list.get(this.index);
			result = true;
		}

		return result;
	}
}
