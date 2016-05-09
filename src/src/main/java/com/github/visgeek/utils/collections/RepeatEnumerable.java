package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Objects;

class RepeatEnumerable<T> implements IListEnumerable<T> {
	// コンストラクター
	RepeatEnumerable(T element, int count) {
		this.element = element;
		this.count = count;
	}

	// フィールド
	private final T element;

	private final int count;

	// メソッド
	@Override
	public final int count() {
		return this.count;
	}

	@Override
	public final boolean contains(T item) {
		boolean result = false;

		if (this.any()) {
			if (Objects.equals(this.element, item)) {
				result = true;
			}
		}

		return result;
	}

	@Override
	public final Iterator<T> iterator() {
		return Enumerable.range(0, this.count()).select(n -> this.element).iterator();
	}

	@Override
	public final T elementAt(int index) {
		if (0 <= index && index < this.count()) {
			return this.element;
		} else {
			throw Errors.argumentOfOutOfRange("index");
		}
	}
}
