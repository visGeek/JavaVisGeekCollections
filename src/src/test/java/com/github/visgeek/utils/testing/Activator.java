package com.github.visgeek.utils.testing;

public class Activator {
	// コンストラクター
	private Activator() {
	}

	// フィールド

	// エンティティメソッド

	// プロパティ

	// メソッド

	// スタティックフィールド

	// スタティックイニシャライザー

	// スタティックプロパティ

	// スタティックメソッド
	public static void create(Class<?> target) {
		try {
			target.newInstance();
		} catch (Exception e) {
			//
		}
	}
}
