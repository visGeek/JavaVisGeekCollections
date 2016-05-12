package com.github.visgeek.utils.collections;

import java.util.HashSet;

class EquatableSet1<T> extends EquatableSet<T> {
	// コンストラクター
	EquatableSet1() {
	}

	// フィールド
	private final HashSet<T> set = new HashSet<>();

	// メソッド
	@Override
	public boolean add(T e) {
		return this.set.add(e);
	}

	@Override
	public boolean contains(T o) {
		return this.set.contains(o);
	}
}
