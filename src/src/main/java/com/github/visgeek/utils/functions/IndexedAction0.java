package com.github.visgeek.utils.functions;

/**
 * インデックスのみを引数とする戻り値がないメソッドを表します。
 */
@FunctionalInterface
public interface IndexedAction0 {
	// メソッド
	void action(int index);

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static IndexedAction0 create(IndexedAction0WithException actionWithException) {
		return index -> {
			try {
				actionWithException.action(index);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
