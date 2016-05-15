package com.github.visgeek.utils.functions;

/**
 * 引数が 4 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 */
@FunctionalInterface
public interface Action4<T1, T2, T3, T4> {
	// メソッド
	void action(T1 arg1, T2 arg2, T3 arg3, T4 arg4);

	/**
	 * 第 1 引数を指定して引数が 3 つメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Action3<T2, T3, T4> partialApply(T1 arg1) {
		return (arg2, arg3, arg4) -> this.action(arg1, arg2, arg3, arg4);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, Action1<T4>>>> curry() {
		return arg1 -> arg2 -> arg3 -> arg4 -> this.action(arg1, arg2, arg3, arg4);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, T4> Action4<T1, T2, T3, T4> create(Action4WithException<T1, T2, T3, T4> actionWithException) {
		return (arg1, arg2, arg3, arg4) -> {
			try {
				actionWithException.action(arg1, arg2, arg3, arg4);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
