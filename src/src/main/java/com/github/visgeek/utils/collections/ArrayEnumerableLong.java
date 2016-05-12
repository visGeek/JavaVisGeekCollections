package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class ArrayEnumerableLong implements IListEnumerable<Long>, ILongCollectionEnumerable {
	// コンストラクター
	public ArrayEnumerableLong(long[] source) {
		this.source = source;
	}

	// フィールド
	private final long[] source;

	// メソッド
	@Override
	public Iterator<Long> iterator() {
		return new AbstractEnumerator<Long>() {
			private int index = -1;

			@Override
			public Long current() {
				return ArrayEnumerableLong.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < ArrayEnumerableLong.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public Long elementAt(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

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
	public long[] toPrimitiveArray() {
		long[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
