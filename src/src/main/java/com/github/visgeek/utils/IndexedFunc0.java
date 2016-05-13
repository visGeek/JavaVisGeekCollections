package com.github.visgeek.utils;

/**
 * インデックスのみを引数とするメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
public interface IndexedFunc0<TResult> {
	// メソッド
	TResult func(int index);

	// スタティックメソッド
	/**
	 * 検査例外のある式をラッピングします。
	 * @param func1WithException
	 * @return
	 */
	public static <TResult> IndexedFunc0<TResult> create(IndexedFunc0WithException<TResult> funcWithException) {
		return index -> {
			try {
				return funcWithException.func(index);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
