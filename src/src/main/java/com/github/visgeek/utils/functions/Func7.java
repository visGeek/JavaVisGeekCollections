package com.github.visgeek.utils.functions;

/**
 * 引数が 7 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <T6>
 * @param <T7>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func7<T1, T2, T3, T4, T5, T6, T7, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7);

	/**
	 * 第 1 引数を指定して引数が 6 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func6<T2, T3, T4, T5, T6, T7, TResult> partialApply(T1 arg1) {
		return (arg2, arg3, arg4, arg5, arg6, arg7) -> this.func(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, Func1<T4, Func1<T5, Func1<T6, Func1<T7, TResult>>>>>>> curry() {
		return arg1 -> arg2 -> arg3 -> arg4 -> arg5 -> arg6 -> arg7 -> this.func(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, T4, T5, T6, T7, TResult> Func7<T1, T2, T3, T4, T5, T6, T7, TResult> create(WithException<T1, T2, T3, T4, T5, T6, T7, TResult> funcWithException) {
		return (arg1, arg2, arg3, arg4, arg5, arg6, arg7) -> {
			try {
				return funcWithException.func(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public static interface WithException<T1, T2, T3, T4, T5, T6, T7, TResult> {
		TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7) throws Exception;
	}
}
