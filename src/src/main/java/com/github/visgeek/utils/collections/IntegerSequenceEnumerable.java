package com.github.visgeek.utils.collections;

import java.util.Iterator;

/**
 * 開始値から終了値までを指定した int のシーケンスを表すクラスです。
 *
 */
class IntegerSequenceEnumerable implements IListEnumerable<Integer>, IIntegerEnumerable {
	// コンストラクター
	IntegerSequenceEnumerable(int start, int end) {
		this.start = start;
		this.end = end;
	}

	// フィールド
	private final int start;

	private final int end;

	// メソッド
	@Override
	public final int count() {
		return this.end - this.start + 1;
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

	@Override
	public final Iterator<Integer> iterator() {
		return IEnumerator.create(() -> start, n -> n <= end, n -> n + 1);
	}

	@Override
	public final Integer elementAt(int index) {
		if (index < 0 || this.count() <= index) {
			throw Errors.ArgumentOfOutOfRange("index");
		} else {
			return this.start + index;
		}
	}
}
