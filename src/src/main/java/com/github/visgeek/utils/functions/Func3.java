package com.github.visgeek.utils.functions;

/**
 * 引数が 3 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func3<T1, T2, T3, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2, T3 arg3);

	/**
	 * 第 1 引数を指定して引数が 2 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func2<T2, T3, TResult> partialApply(T1 arg1) {
		return (arg2, arg3) -> this.func(arg1, arg2, arg3);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, TResult>>> curry() {
		return arg1 -> arg2 -> arg3 -> this.func(arg1, arg2, arg3);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, TResult> Func3<T1, T2, T3, TResult> create(Func3WithException<T1, T2, T3, TResult> funcWithException) {
		return (arg1, arg2, arg3) -> {
			try {
				return funcWithException.func(arg1, arg2, arg3);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
