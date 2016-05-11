package com.github.visgeek.utils.collections;

class ArrayEnumerableChar extends ArrayEnumerable<Character> implements IEnumerable<Character> {
	// コンストラクター
	public ArrayEnumerableChar(char[] source) {
		this.source = source;
	}

	// フィールド
	private final char[] source;

	// メソッド
	@Override
	public Character elementAt(int index) {
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
	public boolean contains(Character item) {
		boolean result = false;

		if (item != null) {
			char primitive = item;
			for (char val : this.source) {
				if (val == primitive) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
}
