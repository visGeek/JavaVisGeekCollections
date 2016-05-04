package jp.visgeek.utils.collections;

class LinqOfTypeIterator<T, TResult extends T> extends AbstractSimpleIterator<T, TResult> {
	public LinqOfTypeIterator(Iterable<T> source, Class<TResult> elementClass) {
		super(source);
		this.elementClass = elementClass;
	}

	private final Class<TResult> elementClass;

	private TResult currentValue;

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasNext() {
		boolean result = false;

		while (this.iterator.hasNext()) {
			T tmp = this.iterator.next();
			// if (tmp != null && tmp.getClass().isAssignableFrom(clazz)) {
			if (tmp != null && this.elementClass.isAssignableFrom(tmp.getClass())) {
				this.currentValue = (TResult) tmp;
				result = true;
				break;
			}
		}

		return result;
	}

	@Override
	public TResult next() {
		return this.currentValue;
	}
}
