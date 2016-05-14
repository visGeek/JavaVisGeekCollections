package com.github.visgeek.utils.collections;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Set;

@SuppressWarnings("unchecked")
public interface ISet<T> extends Set<T>, IReadOnlySet<T>, Cloneable, Serializable {
	default boolean addAll(Iterable<? extends T> collection) {
		Errors.throwIfNull(collection, "collection");
		boolean result = false;

		if (collection instanceof Collection<?>) {
			result = this.addAll((Collection<T>) collection);
		} else {
			for (T item : collection) {
				if (this.add(item)) {
					result = true;
				}
			}
		}

		return result;
	}

	default void addOrThrow(T e) {
		if (this.containsValue(e)) {
			throw new IllegalArgumentException(String.format("%s already exists.", e));
		} else {
			this.add(e);
		}
	}

	@Override
	boolean contains(Object o);

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
	boolean isEmpty();

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
		T[] array = (T[]) Array.newInstance(elementClass, this.count());
		return this.toArray(array);
	}
}
