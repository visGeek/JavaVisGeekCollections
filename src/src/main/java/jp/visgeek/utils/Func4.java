package jp.visgeek.utils;

/**
 * 引数が 4 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func4<T1, T2, T3, T4, TResult> {
	// メソッド
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4);

	/**
	 * 第 1 引数を指定して引数が 3 つのメソッドに変換します。
	 * @param arg1
	 * @return
	 */
	default Func3<T2, T3, T4, TResult> toFunc3(T1 arg1) {
		return (arg2, arg3, arg4) -> this.func(arg1, arg2, arg3, arg4);
	}

	/**
	 * カリー化します。
	 * @return
	 */
	default Func1<T1, Func1<T2, Func1<T3, Func1<T4, TResult>>>> curry() {
		return arg1 -> arg2 -> arg3 -> arg4 -> this.func(arg1, arg2, arg3, arg4);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T1, T2, T3, T4, TResult> Func4<T1, T2, T3, T4, TResult> create(Func4WithException<T1, T2, T3, T4, TResult> funcWithException) {
		return (arg1, arg2, arg3, arg4) -> {
			try {
				return funcWithException.func(arg1, arg2, arg3, arg4);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
