package com.github.visgeek.utils.collections;

class ArrayEnumerableLong extends ArrayEnumerable<Long> implements ILongEnumerable {
	// コンストラクター
	public ArrayEnumerableLong(long[] source) {
		this.source = source;
	}

	// フィールド
	private final long[] source;

	// メソッド
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
}
