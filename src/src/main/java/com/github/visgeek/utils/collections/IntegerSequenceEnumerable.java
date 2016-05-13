package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.IndexedFunc0;

/**
 * 開始値から終了値までを指定した int のシーケンスを表すクラスです。
 *
 */
class IntegerSequenceEnumerable<T> implements IListEnumerable<T> {
	// コンストラクター
	IntegerSequenceEnumerable(int start, int end, IndexedFunc0<? extends T> selector) {
		this.start = start;
		this.end = end;
		this.selector = selector;
	}

	// フィールド
	final int start;

	final int end;

	private final IndexedFunc0<? extends T> selector;

	// メソッド
	@Override
	public final int count() {
		return this.end - this.start + 1;
	}

	@Override
	public final Iterator<T> iterator() {
		return new AbstractEnumerator<T>() {
			boolean first = true;

			private int current;

			@Override
			public T current() {
				return selector.func(this.current);
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				if (this.first) {
					this.first = false;
					this.current = IntegerSequenceEnumerable.this.start;
				} else {
					this.current++;
				}

				if (this.current <= IntegerSequenceEnumerable.this.end) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public final T elementAt(int index) {
		if (index < 0 || this.count() <= index) {
			throw Errors.argumentOfOutOfRange("index");
		} else {
			return this.selector.func(this.start + index);
		}
	}

	static class IntegerEnumerable extends IntegerSequenceEnumerable<Integer> implements IIntegerEnumerable {
		IntegerEnumerable(int start, int end) {
			super(start, end, index -> index);
		}

		@Override
		public final boolean contains(Integer item) {
			boolean result = false;

			if (item != null) {
				if (this.start <= item) {
					if (item <= this.end) {
						result = true;
					}
				}
			}

			return result;
		}
	}
}
