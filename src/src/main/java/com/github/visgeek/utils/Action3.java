package com.github.visgeek.utils;

/**
 * 引数が 3 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
@FunctionalInterface
public interface Action3<T1, T2, T3> {
	// メソッド
	void action(T1 arg1, T2 arg2, T3 arg3);

	/**
	 * 第 1 引数を指定して引数が 2 つメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Action2<T2, T3> partialApply(T1 arg1) {
		return (arg2, arg3) -> this.action(arg1, arg2, arg3);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Action1<T3>>> curry() {
		return arg1 -> arg2 -> arg3 -> this.action(arg1, arg2, arg3);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3> Action3<T1, T2, T3> create(Action3WithException<T1, T2, T3> actionWithException) {
		return (arg1, arg2, arg3) -> {
			try {
				actionWithException.action(arg1, arg2, arg3);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
