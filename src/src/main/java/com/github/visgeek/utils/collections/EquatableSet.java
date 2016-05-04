package com.github.visgeek.utils.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.github.visgeek.utils.IEqualityComparator;

/**
 * EqualityComparator<T> インターフェイスを使った比較を行うハッシュセットです。
 * @param <T>
 */
class EquatableSet<T> implements Set<T> {
	// コンストラクター
	private EquatableSet(IEqualityComparator<? super T> comparator) {
		this.comparator = comparator;
	}

	// フィールド
	private final HashSet<Entry> set = new HashSet<Entry>();

	private final IEqualityComparator<? super T> comparator;

	private final Entry entryForCompare = new Entry(null);

	// メソッド
	@Override
	public boolean add(T e) {
		return this.set.add(new Entry(e));
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new IllegalStateException();
	}

	@Override
	public void clear() {
		this.set.clear();
	}

	@Override
	public boolean contains(Object o) {
		@SuppressWarnings("unchecked")
		T cast = (T) o;
		this.entryForCompare.obj = cast;
		return this.set.contains(this.entryForCompare);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new IllegalStateException();
	}

	@Override
	public boolean isEmpty() {
		return this.set.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		throw new IllegalStateException();
	}

	@Override
	public boolean remove(Object o) {
		throw new IllegalStateException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new IllegalStateException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new IllegalStateException();
	}

	@Override
	public int size() {
		return this.set.size();
	}

	@Override
	public Object[] toArray() {
		throw new IllegalStateException();
	}

	@Override
	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		throw new IllegalStateException();
	}

	// クラス
	private class Entry {
		public Entry(T obj) {
			this.obj = obj;
		}

		private T obj;

		@Override
		public boolean equals(Object obj) {
			boolean result = false;

			if (obj != null) {
				@SuppressWarnings("unchecked")
				T cast = ((Entry) obj).obj;
				result = comparator.equals(this.obj, cast);
			}

			return result;
		}

		@Override
		public int hashCode() {
			return comparator.hashCode(this.obj);
		}
	}

	// スタティックメソッド
	public static <T> Set<T> create(IEqualityComparator<? super T> comparator) {
		if (comparator == null) {
			return new HashSet<T>();
		} else {
			return new EquatableSet<T>(comparator);
		}
	}
}
