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

	public static UnsupportedOperationException noMatch() {
		return new UnsupportedOperationException("シーケンスに、条件に適合する要素が一つもありません。");
	}

	public static UnsupportedOperationException moreThanOneElement() {
		return new UnsupportedOperationException("シーケンスに複数の要素が含まれています。");
	}

	public static UnsupportedOperationException moreThanOneMatch() {
		return new UnsupportedOperationException("シーケンスに、条件に適合する要素が複数含まれています。");
	}

	public static IllegalArgumentException argumentOfOutOfRange(String argName) {
		String message = String.format("", argName);
		return new IllegalArgumentException(message);
	}

	public static IllegalArgumentException notComparable() {
		return new IllegalArgumentException("IComparable に変換出来ません。");
	}

	public static <T> T throwIfNull(T parameter, String name) {
		if (parameter == null) {
			throw new NullPointerException(name);
		} else {
			return parameter;
		}
	}

	static {
		new Errors();
	}
}
