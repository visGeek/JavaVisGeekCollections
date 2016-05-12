package com.github.visgeek.utils.collections;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public interface IList<T> extends List<T>, IListEnumerable<T>, IReadOnlyList<T>, Cloneable, Serializable {
	default boolean addAll(Iterable<? extends T> c) {
		return this.addAll(this.size(), c);
	}

	default boolean addAll(int index, Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			result = this.addAll(index, (Collection<T>) c);
		} else {
			int idx = index;
			for (T item : c) {
				this.add(idx, item);
				idx++;
				result = true;
			}
		}

		return result;
	}

	/**
	 * contains(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	default boolean containsValue(T o) {
		return this.contains(o);
	}

	/**
	 * indexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	default int indexOfValue(T o) {
		return this.indexOf(o);
	}

	/**
	 * lastIndexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	default int lastIndexOfValue(T o) {
		return this.lastIndexOf(o);
	}

	/**
	 * remove(int index) と同じ動作です。
	 * @param index
	 * @return
	 */
	default T removeAt(int index) {
		return this.remove(index);
	}

	/**
	 * remove(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	default boolean removeValue(T o) {
		return this.remove(o);
	}

	default boolean removeAllValues(Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			result = this.removeAll((Collection<T>) c);
		} else {
			for (T item : c) {
				while (this.removeValue(item)) {
					result = true;
				}
			}
		}

		return result;
	}

	@Override
	default T[] toArray(Class<T> elementClass) {
		Errors.throwIfNull(elementClass, "elementClass");

		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		return this.toArray(array);
	}
}
