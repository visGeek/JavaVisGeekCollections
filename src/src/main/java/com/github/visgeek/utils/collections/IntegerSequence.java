package com.github.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Objects;

import com.github.visgeek.utils.functions.IndexedFunc0;

/**
 * 開始値から終了値までを指定した int のシーケンスを表すクラスです。
 *
 */
class IntegerSequence<T> implements IReadOnlyList<T> {
	// コンストラクター
	IntegerSequence(int start, int end, IndexedFunc0<? extends T> selector) {
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
	public final T get(int index) {
		if (index < 0 || this.count() <= index) {
			throw Errors.argumentOfOutOfRange("index");
		} else {
			return this.selector.func(this.start + index);
		}
	}

	@Override
	public final Iterator<T> iterator() {
		return new Enumerator<T>() {
			boolean first = true;

			private int current;

			@Override
			public T current() {
				return IntegerSequence.this.selector.func(this.current);
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				if (this.first) {
					this.first = false;
					this.current = IntegerSequence.this.start;
				} else {
					this.current++;
				}

				if (this.current <= IntegerSequence.this.end) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public final int size() {
		return this.end - this.start + 1;
	}

	// スタティッククラス
	static class IntegerEnumerable extends IntegerSequence<Integer> implements IIntegerEnumerable {
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

	static class RepeatEnumerable<T> extends IntegerSequence<T> {
		RepeatEnumerable(int count, T element) {
			super(0, count - 1, index -> element);
		}

		@Override
		public final boolean contains(T item) {
			boolean result = false;

			if (this.any()) {
				if (Objects.equals(this.elementAt(0), item)) {
					result = true;
				}
			}

			return result;
		}
	}
}
