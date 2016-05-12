package com.github.visgeek.utils.collections;

import java.util.HashSet;

import com.github.visgeek.utils.IEqualityComparator;

class EquatableSet2<T> extends EquatableSet<T> {
	// コンストラクター
	EquatableSet2(IEqualityComparator<? super T> comparator) {
		this.comparator = comparator;
	}

	// フィールド
	private final HashSet<Entry> set = new HashSet<>();

	private final IEqualityComparator<? super T> comparator;

	// メソッド
	@Override
	public boolean add(T e) {
		return this.set.add(new Entry(e));
	}

	@Override
	public boolean contains(T o) {
		return this.set.contains(new Entry(o));
	}

	// クラス
	private class Entry {
		Entry(T obj) {
			this.obj = obj;
		}

		private final T obj;

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			T cast = ((Entry) obj).obj;
			boolean result = EquatableSet2.this.comparator.equals(this.obj, cast);
			return result;
		}

		@Override
		public int hashCode() {
			return EquatableSet2.this.comparator.hashCode(this.obj);
		}
	}
}
