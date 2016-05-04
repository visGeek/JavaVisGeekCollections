package com.github.visgeek.utils;

/**
 * 引数が 1 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 */
@FunctionalInterface
public interface Action1<T> {
	// メソッド
	void action(T arg);

	/**
	 * 引数を指定して引数がないメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Action0 toAction0(T arg) {
		return () -> this.action(arg);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1> Action1<T1> create(Action1WithException<T1> actionWithException) {
		return arg1 -> {
			try {
				actionWithException.action(arg1);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
