package com.github.visgeek.utils.collections;

import java.lang.reflect.Array;
import java.util.Collection;

public class EnumerableSet<T> extends java.util.HashSet<T> implements IReadOnlySet<T> {
	// コンストラクター
	public EnumerableSet() {
		super();
	}

	public EnumerableSet(Collection<T> collection) {
		super(collection);
	}

	public EnumerableSet(Iterable<? extends T> collection) {
		this();
		if (collection instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> c = (Collection<T>) collection;
			this.addAll(c);
		} else {
			this.addAll(collection);
		}
	}

	@SafeVarargs
	public EnumerableSet(T... values) {
		this();
		this.addAll(Enumerable.of(values));
	}

	public EnumerableSet(int initialCapacity) {
		super(initialCapacity);
	}

	// フィールド

	// メソッド
	public void addOrThrow(T e) {
		if (this.containsValue(e)) {
			throw new IllegalArgumentException(String.format("%s is already contained.", e));
		} else {
			this.add(e);
		}
	}

	public boolean addAll(Iterable<? extends T> collection) {
		boolean result = false;

		if (collection instanceof Collection<?>) {
			@SuppressWarnings("unchecked")
			Collection<T> c = (Collection<T>) collection;
			result = super.addAll(c);
		} else {
			for (T item : collection) {
				if (this.add(item)) {
					result = true;
				}
			}
		}

		return result;
	}

	@Override
	public EnumerableSet<T> clone() {
		return new EnumerableSet<T>(this);
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
	@Deprecated
	public boolean remove(Object o) {
		return super.remove(o);
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
	public T[] toArray(Class<T> elementClass) {
		Errors.throwIfNull(elementClass, "elementClass");

		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(elementClass, this.count());

		return this.toArray(array);
	}

	// スタティックフィールド
	private static final long serialVersionUID = -3993841242732244607L;

	// スタティックメソッド
}
