package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;

interface ICollectionEnumerable<T> extends IEnumerable<T> {
	@Override
	default boolean any() {
		return this.count() != 0;
	}

	@Override
	int count();

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
