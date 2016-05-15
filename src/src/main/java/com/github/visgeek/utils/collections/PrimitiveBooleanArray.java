package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class PrimitiveBooleanArray implements IReadOnlyList<Boolean>, IBooleanCollection {
	// コンストラクター
	public PrimitiveBooleanArray(boolean[] source) {
		this.source = source;
	}

	// フィールド
	private final boolean[] source;

	// メソッド
	@Override
	public boolean contains(Boolean item) {
		boolean result = false;

		if (item != null) {
			boolean primitive = item;
			for (boolean val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Boolean get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Boolean> iterator() {
		return new AbstractEnumerator<Boolean>() {
			private int index = -1;

			@Override
			public Boolean current() {
				return PrimitiveBooleanArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < PrimitiveBooleanArray.this.count()) {
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
	public boolean[] toPrimitiveArray() {
		boolean[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
