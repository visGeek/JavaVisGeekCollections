package com.github.visgeek.utils.collections;

class ArrayEnumeratorLong extends AbstractEnumerator<Long> {
	// コンストラクター
	public ArrayEnumeratorLong(long[] array) {
		this.array = array;
	}

	// フィールド
	private final long[] array;

	private int idx = -1;

	// プロパティ
	@Override
	public Long current() {
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
