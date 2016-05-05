package com.github.visgeek.utils.collections;

class ArrayEnumerator<T> extends AbstractEnumerator<T> {
	// コンストラクター
	public ArrayEnumerator(T[] array) {
		this.array = array;
	}

	// フィールド
	private final T[] array;

	private int idx = -1;

	// プロパティ
	@Override
	public T current() {
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
