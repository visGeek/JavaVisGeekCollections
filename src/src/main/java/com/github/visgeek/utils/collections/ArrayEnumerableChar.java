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
			throw Errors.ArgumentOfOutOfRange("index");
		}
	}

	@Override
	public int count() {
		return this.source.length;
	}

	@Override
	public boolean contains(Character item) {
		boolean result = false;

		for (char val : this.source) {
			if (val == item) {
				result = true;
				break;
			}
		}

		return result;
	}
}
