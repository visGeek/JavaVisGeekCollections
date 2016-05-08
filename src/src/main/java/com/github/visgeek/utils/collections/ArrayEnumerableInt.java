package com.github.visgeek.utils.collections;

class ArrayEnumerableInt extends ArrayEnumerable<Integer> implements IIntegerEnumerable {
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
			throw new IndexOutOfBoundsException(e.getMessage());
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

	@Override
	public boolean contains(Integer item) {
		boolean result = false;

		for (int val : this.source) {
			if (val == item) {
				result = true;
				break;
			}
		}

		return result;
	}
}
=======
package com.github.visgeek.utils.collections;

class ArrayEnumerableInt extends ArrayEnumerable<Integer> implements IIntegerEnumerable {
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
			throw new IndexOutOfBoundsException(e.getMessage());
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

	@Override
	public boolean contains(Integer item) {
		boolean result = false;

		for (int val : this.source) {
			if (val == item) {
				result = true;
				break;
			}
		}

		return result;
	}
}
