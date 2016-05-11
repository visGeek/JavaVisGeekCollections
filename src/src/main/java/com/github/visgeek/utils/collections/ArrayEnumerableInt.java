package com.github.visgeek.utils.collections;

import java.util.Arrays;

class ArrayEnumerableInt extends ArrayEnumerable<Integer> implements IIntegerCollectionEnumerable {
	// コンストラクター
	public ArrayEnumerableInt(int[] source) {
		this.source = source;
	}

	// フィールド
	private final int[] source;

	// メソッド
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
