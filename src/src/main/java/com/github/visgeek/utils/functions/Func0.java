package com.github.visgeek.utils.functions;

/**
 * 引数がなく戻り値があるメソッドを表します。
 * @param <TResult>
 */
@FunctionalInterface
public interface Func0<TResult> {
	// メソッド
	TResult func();

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <TResult> Func0<TResult> create(WithException<TResult> funcWithException) {
		return () -> {
			try {
				return funcWithException.func();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public interface WithException<TResult> {
		TResult func();
	}
}
