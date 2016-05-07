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
			throw new IndexOutOfBoundsException(e.getMessage());
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

	@Override
	public boolean contains(Long item) {
		boolean result = false;

		for (Long val : this.source) {
			if (val == item) {
				result = true;
				break;
			}
		}

		return result;
	}
}
