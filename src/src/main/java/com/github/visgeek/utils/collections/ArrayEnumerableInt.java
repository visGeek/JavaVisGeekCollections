package com.github.visgeek.utils.collections;

import java.util.Arrays;
import java.util.Iterator;

class ArrayEnumerableInt implements IListEnumerable<Integer>, IIntegerCollectionEnumerable {
	// コンストラクター
	public ArrayEnumerableInt(int[] source) {
		this.source = source;
	}

	// フィールド
	private final int[] source;

	// メソッド
	@Override
	public Iterator<Integer> iterator() {
		return new AbstractEnumerator<Integer>() {
			private int index = -1;

			@Override
			public Integer current() {
				return ArrayEnumerableInt.this.source[this.index];
			}

			@Override
			public boolean moveNext() {
				boolean result = false;

				this.index++;
				if (this.index < ArrayEnumerableInt.this.count()) {
					result = true;
				}

				return result;
			}
		};
	}

	@Override
	public Integer elementAt(int index) {
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
	public int[] toPrimitiveArray() {
		int[] array = Arrays.copyOf(this.source, this.count());
		return array;
	}
}
