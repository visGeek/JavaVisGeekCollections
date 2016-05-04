package com.github.visgeek.utils;

/**
 * 引数が 5 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func5<T1, T2, T3, T4, T5, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5);

	/**
	 * 第 1 引数を指定して引数が 4 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func4<T2, T3, T4, T5, TResult> toFunc4(T1 arg1) {
		return (arg2, arg3, arg4, arg5) -> this.func(arg1, arg2, arg3, arg4, arg5);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, Func1<T4, Func1<T5, TResult>>>>> curry() {
		return arg1 -> arg2 -> arg3 -> arg4 -> arg5 -> this.func(arg1, arg2, arg3, arg4, arg5);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, T4, T5, TResult> Func5<T1, T2, T3, T4, T5, TResult> create(Func5WithException<T1, T2, T3, T4, T5, TResult> funcWithException) {
		return (arg1, arg2, arg3, arg4, arg5) -> {
			try {
				return funcWithException.func(arg1, arg2, arg3, arg4, arg5);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
