package com.github.visgeek.utils.testing;

public class Tuple {
	private Tuple() {
	}

	public static <T1, T2, T3> Tuple3<T1, T2, T3> create(T1 item1, T2 item2, T3 item3) {
		return new Tuple3<>(item1, item2, item3);
	}

	static {
		new Tuple(); // カバレッジのため。
	}
}
