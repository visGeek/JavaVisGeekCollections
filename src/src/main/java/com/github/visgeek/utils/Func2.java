package com.github.visgeek.utils;

/**
 * 引数が 2 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func2<T1, T2, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2);

	/**
	 * 第 1 引数を指定して引数が 1 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func1<T2, TResult> toFunc1(T1 arg1) {
		return arg2 -> this.func(arg1, arg2);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, TResult>> curry() {
		return arg1 -> arg2 -> this.func(arg1, arg2);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, TResult> Func2<T1, T2, TResult> create(Func2WithException<T1, T2, TResult> funcWithException) {
		return (arg1, arg2) -> {
			try {
				return funcWithException.func(arg1, arg2);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
