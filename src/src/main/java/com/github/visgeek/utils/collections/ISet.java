package com.github.visgeek.utils.collections;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Set;

public interface ISet<T> extends Set<T>, ICollectionEnumerable<T>, IReadOnlySet<T>, Cloneable, Serializable {
	default void addOrThrow(T e) {
		if (this.containsValue(e)) {
			throw new IllegalArgumentException(String.format("%s is already contained.", e));
		} else {
			this.add(e);
		}
	}

	default boolean addAll(Iterable<? extends T> collection) {
		boolean result = false;

		if (collection instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> c = (Collection<T>) collection;
			result = this.addAll(c);
		} else {
			for (T item : collection) {
				if (this.add(item)) {
					result = true;
				}
			}
		}

		return result;
	}

	/**
	 * contains(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	@Override
	default boolean containsValue(T o) {
		return this.contains(o);
	}

	@Override
	default int count() {
		return this.size();
	}

	/**
	 * remove(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	default boolean removeValue(T o) {
		return this.remove(o);
	}

	@Override
	default T[] toArray(Class<T> elementClass) {
		Errors.throwIfNull(elementClass, "elementClass");

		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		return this.toArray(array);
	}
}
