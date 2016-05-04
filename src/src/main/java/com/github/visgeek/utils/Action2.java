package com.github.visgeek.utils;

/**
 * 引数が 2 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 */
@FunctionalInterface
public interface Action2<T1, T2> {
	// メソッド
	void action(T1 arg1, T2 arg2);

	/**
	 * 第 1 引数を指定して引数が 1 つメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Action1<T2> toAction1(T1 arg1) {
		return arg2 -> this.action(arg1, arg2);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Action1<T2>> curry() {
		return arg1 -> arg2 -> this.action(arg1, arg2);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2> Action2<T1, T2> create(Action2WithException<T1, T2> actionWithException) {
		return (arg1, arg2) -> {
			try {
				actionWithException.action(arg1, arg2);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
