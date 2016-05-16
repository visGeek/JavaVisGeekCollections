package com.github.visgeek.utils.functions;

/**
 * 引数が 1 つで戻り値があるメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func1<T, TResult> {
	// メソッド
	TResult func(T arg);

	/**
	 * 引数を指定して引数がないメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default Func0<TResult> partialApply(T arg) {
		return () -> this.func(arg);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <T, TResult> Func1<T, TResult> create(WithException<T, TResult> funcWithException) {
		return arg -> {
			try {
				return funcWithException.func(arg);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public static interface WithException<T, TResult> {
		TResult func(T arg) throws Exception;
	}
}
