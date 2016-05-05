package com.github.visgeek.utils.collections;

class ArrayEnumeratorInt extends AbstractEnumerator<Integer> {
	// コンストラクター
	public ArrayEnumeratorInt(int[] array) {
		this.array = array;
	}

	// フィールド
	private final int[] array;

	private int idx = -1;

	// プロパティ
	@Override
	public Integer current() {
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
