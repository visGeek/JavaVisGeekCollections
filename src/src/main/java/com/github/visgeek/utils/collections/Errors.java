package com.github.visgeek.utils.collections;

class Errors {
	// コンストラクター
	private Errors() {
	}

	// メソッド
	public static UnsupportedOperationException invalidOperation() {
		return new UnsupportedOperationException("不正な操作です。");
	}

	public static UnsupportedOperationException empty() {
		return new UnsupportedOperationException("シーケンスに要素が一つもありません。");
	}

	public static IllegalStateException noMatch() {
		return new IllegalStateException("シーケンスに、条件に適合する要素が一つもありません。");
	}

	public static IllegalStateException moreThanOneElement() {
		return new IllegalStateException("シーケンスに複数の要素が含まれています。");
	}

	public static IllegalStateException moreThanOneMatch() {
		return new IllegalStateException("シーケンスに、条件に適合する要素が複数含まれています。");
	}

	public static IllegalArgumentException ArgumentOfOutOfRange(String argName) {
		String message = String.format("", argName);
		return new IllegalArgumentException(message);
	}

	public static void throwIfNull(Object parameter, String name) {
		if (parameter == null) {
			throw new NullPointerException(name);
		}
	}
}
