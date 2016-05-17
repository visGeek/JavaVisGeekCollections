package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class PrimitiveIntegerArray implements IReadOnlyList<Integer>, IIntegerCollection {
	// コンストラクター
	public PrimitiveIntegerArray(int[] source) {
		this.source = source;
	}

	// フィールド
	private final int[] source;

	// メソッド
	@Override
	public boolean contains(Integer item) {
		boolean result = false;

		if (item != null) {
			int primitive = item;
			for (int val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	@Override
	public Integer get(int index) {
		try {
			return this.source[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw Errors.argumentOfOutOfRange("index");
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Enumerator<Integer>() {
			private int index = -1;

			@Override
			public Integer current() {
				return PrimitiveIntegerArray.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < PrimitiveIntegerArray.this.count()) {
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
	public int[] toPrimitiveArray() {
		int[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
