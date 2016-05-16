package com.github.visgeek.utils.functions;

/**
 * 1 つの指定した型の値とインデックスを引数とする戻り値がないメソッドを表します。
 * @param <T>
 */
@FunctionalInterface
public interface IndexedAction1<T> {
	// メソッド
	void action(T arg, int index);

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static <T> IndexedAction1<T> create(WithException<T> actionWithException) {
		return (arg, index) -> {
			try {
				actionWithException.action(arg, index);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}

	@FunctionalInterface
	public static interface WithException<T> {
		void action(T arg, int index) throws Exception;
	}
}
