package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;
import java.util.Collection;

public class EnumerableLinkedList<T> extends java.util.LinkedList<T> implements IReadOnlyList<T> {
	// コンストラクター
	public EnumerableLinkedList() {
		super();
	}

	public EnumerableLinkedList(Collection<? extends T> collection) {
		super(collection);
	}

	public EnumerableLinkedList(Iterable<? extends T> collection) {
		this();
		this.addAll(collection);
	}

	@SafeVarargs
	public EnumerableLinkedList(T... values) {
		for (T value : values) {
			this.add(value);
		}
	}

	// フィールド

	// メソッド
	public boolean addAll(Iterable<? extends T> c) {
		return this.addAll(this.size(), c);
	}

	public boolean addAll(int index, Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = this.addAll(index, vals);
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

	@Override
	public boolean any() {
		return !this.isEmpty();
	}

	@Override
	public EnumerableLinkedList<T> clone() {
		return new EnumerableLinkedList<>(this);
	}

	@Override
	@Deprecated
	public boolean contains(Object o) {
		return super.contains(o);
	}

	/**
	 * contains(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean containsValue(T o) {
		return super.contains(o);
	}

	@Override
	public int count() {
		return this.size();
	}

	@Override
	public T elementAt(int index) {
		return this.get(index);
	}

	@Override
	@Deprecated
	public int indexOf(Object o) {
		return super.indexOf(o);
	}

	/**
	 * indexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public int indexOfValue(T o) {
		return super.indexOf(o);
	}

	@Override
	@Deprecated
	public int lastIndexOf(Object o) {
		return super.lastIndexOf(o);
	}

	/**
	 * lastIndexOf(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public int lastIndexOfValue(T o) {
		return super.lastIndexOf(o);
	}

	@Override
	@Deprecated
	public T remove(int index) {
		return super.remove(index);
	}

	@Override
	@Deprecated
	public boolean remove(Object o) {
		return super.remove(o);
	}

	/**
	 * remove(int index) と同じ動作です。
	 * @param index
	 * @return
	 */
	public T removeAt(int index) {
		return super.remove(index);
	}

	/**
	 * remove(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeValue(T o) {
		return super.remove(o);
	}

	@Override
	@Deprecated
	public boolean removeFirstOccurrence(Object o) {
		return super.removeFirstOccurrence(o);
	}

	/**
	 * removeFirstOccurrence(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeFirstOccurredValue(T o) {
		return super.removeFirstOccurrence(o);
	}

	@Override
	@Deprecated
	public boolean removeLastOccurrence(Object o) {
		return super.removeLastOccurrence(o);
	}

	/**
	 * removeLastOccurrence(Object o) と同じ動作です。
	 * @param o
	 * @return
	 */
	public boolean removeLastOccurredValue(T o) {
		return super.removeLastOccurrence(o);
	}

	@Override
	@Deprecated
	public boolean removeAll(Collection<?> c) {
		return super.removeAll(c);
	}

	public boolean removeAllValues(Iterable<? extends T> c) {
		boolean result = false;

		if (c instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> vals = (Collection<T>) c;
			result = super.removeAll(vals);
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
	public T[] toArray(Class<T> elementClass) {
		Errors.throwIfNull(elementClass, "elementClass");

		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		return this.toArray(array);
	}

	@Override
	public String toString() {
		return String.format("size:%d", this.size());
	}

	// スタティックフィールド
	private static final long serialVersionUID = -2806056720008680671L;

	private static final IReadOnlyList<Object> _emptyReadOnlyList = new EnumerableLinkedList<>();

	// スタティックメソッド
	public static <T> EnumerableLinkedList<T> create(Iterable<T> collection) {
		return new EnumerableLinkedList<>(collection);
	}

	@SafeVarargs
	public static <T> EnumerableLinkedList<T> create(T... values) {
		return new EnumerableLinkedList<>(values);
	}

	public static <T> IReadOnlyList<T> getEmptyReadOnlyList() {
		@SuppressWarnings("unchecked")
		IReadOnlyList<T> result = (IReadOnlyList<T>) EnumerableLinkedList._emptyReadOnlyList;
		return result;
	}
}
