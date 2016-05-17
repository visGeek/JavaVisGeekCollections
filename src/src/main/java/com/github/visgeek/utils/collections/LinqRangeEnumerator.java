package com.github.visgeek.utils.collections;

class LinqRangeEnumerator extends Enumerator<Integer> {
	// コンストラクター
	public LinqRangeEnumerator(int start, int count) {
		this.start = start;
		this.count = count;
	}

	// フィールド
	private final int start;

	private final int count;

	private int current = 0;

	private int cnt = 0;

	// プロパティ
	@Override
	public Integer current() {
		return this.current;
	}

	// メソッド
	@Override
	public boolean moveNext() {
		boolean result = false;

		if (this.cnt < count) {
			this.current = start + this.cnt;
			this.cnt++;
			result = true;
		}

		return result;
	}

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックメソッド
}
