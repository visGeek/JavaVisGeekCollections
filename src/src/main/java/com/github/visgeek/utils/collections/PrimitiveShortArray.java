package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class PrimitiveShortArray implements IReadOnlyList<Short>, IShortCollection {
	// コンストラクター
	public PrimitiveShortArray(short[] source) {
		this.source = source;
	}

	// フィールド
	private final short[] source;

	// メソッド
	@Override
	public boolean contains(Short item) {
		boolean result = false;

		if (item != null) {
			short primitive = item;
			for (short val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Short get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Short> iterator() {
		return new Enumerator<Short>() {
			private int index = -1;

			@Override
			public Short current() {
				return PrimitiveShortArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < PrimitiveShortArray.this.count()) {
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
	public short[] toPrimitiveArray() {
		short[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
