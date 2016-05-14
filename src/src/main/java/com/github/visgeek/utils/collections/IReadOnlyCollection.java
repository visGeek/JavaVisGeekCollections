package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;

public interface IReadOnlyCollection<T> extends IEnumerable<T> {
	int size();

	default boolean isEmpty() {
		return !this.any();
	}

	@Override
	default int count() {
		return this.size();
	}

	@Override
	default boolean any() {
		return this.count() != 0;
	}

	@Override
	default T[] toArray(Class<T> elementClass) {
		Errors.throwIfNull(elementClass, "elementClass");

		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		int i = -1;
		for (T item : this) {
			i++;
			array[i] = item;
		}

		return array;
	}
}
