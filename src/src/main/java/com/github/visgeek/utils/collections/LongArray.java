package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class LongArray implements IReadOnlyList<Long>, ILongCollection {
	// コンストラクター
	public LongArray(long[] source) {
		this.source = source;
	}

	// フィールド
	private final long[] source;

	// メソッド
	@Override
	public boolean contains(Long item) {
		boolean result = false;

		if (item != null) {
			long primitive = item;
			for (long val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Long get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Long> iterator() {
		return new AbstractEnumerator<Long>() {
			private int index = -1;

			@Override
			public Long current() {
				return LongArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < LongArray.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public int size() {
		return this.source.length;
	}

	@Override
	public long[] toPrimitiveArray() {
		long[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
