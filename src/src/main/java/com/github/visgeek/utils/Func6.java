package com.github.visgeek.utils;

/**
 * 引数が 6 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <T6>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func6<T1, T2, T3, T4, T5, T6, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6);

	/**
	 * 第 1 引数を指定して引数が 5 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func5<T2, T3, T4, T5, T6, TResult> partialApply(T1 arg1) {
		return (arg2, arg3, arg4, arg5, arg6) -> this.func(arg1, arg2, arg3, arg4, arg5, arg6);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, Func1<T4, Func1<T5, Func1<T6, TResult>>>>>> curry() {
		return arg1 -> arg2 -> arg3 -> arg4 -> arg5 -> arg6 -> this.func(arg1, arg2, arg3, arg4, arg5, arg6);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, T4, T5, T6, TResult> Func6<T1, T2, T3, T4, T5, T6, TResult> create(Func6WithException<T1, T2, T3, T4, T5, T6, TResult> funcWithException) {
		return (arg1, arg2, arg3, arg4, arg5, arg6) -> {
			try {
				return funcWithException.func(arg1, arg2, arg3, arg4, arg5, arg6);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
