package com.github.visgeek.utils.functions;

/**
 * 1 つの指定した型の値とインデックスを引数とするメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
public interface IndexedFunc1<T, TResult> {
	// メソッド
	TResult func(T arg, int index);

	/**
	 * 引数を指定して、インデックスのみを引数とするメソッドに変換します。
	 * @param arg
	 * @return
	 */
	default IndexedFunc0<TResult> partialApply(T arg) {
		return index -> this.func(arg, index);
	}

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <T, TResult> IndexedFunc1<T, TResult> create(WithException<T, TResult> funcWithException) {
		return (arg, index) -> {
			try {
				return funcWithException.func(arg, index);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public static interface WithException<T, TResult> {
		TResult func(T arg, int index) throws Exception;
	}
}
