package com.github.visgeek.utils.collections;

class ArrayEnumeratorChar extends AbstractEnumerator<Character> {
	// コンストラクター
	public ArrayEnumeratorChar(char[] array) {
		this.array = array;
	}

	// フィールド
	private final char[] array;

	private int idx = -1;

	// プロパティ
	@Override
	public Character current() {
		return this.array[this.idx];
	}

	// メソッド
	@Override
	public boolean moveNext() {
		boolean result = false;

		this.idx++;
		if (this.idx < this.array.length) {
			result = true;
		}


		return result;
	}

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックプロパティ

	// スタティックメソッド
}
