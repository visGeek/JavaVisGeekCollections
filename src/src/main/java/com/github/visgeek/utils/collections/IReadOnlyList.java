package com.github.visgeek.utils.collections;

public interface IReadOnlyList<T> extends IReadOnlyCollection<T>, IListEnumerable<T> {
	T get(int index);

	@Override
	default T elementAt(int index) {
		try {
			return this.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}
}
