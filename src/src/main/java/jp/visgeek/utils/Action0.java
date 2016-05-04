package jp.visgeek.utils;

/**
 * 引数と戻り値がないメソッドを表します。
 */
@FunctionalInterface
public interface Action0 {
	// メソッド
	void action();

	// スタティックメソッド
	/**
	 * 検査例外のある処理をラッピングします。
	 * @param funcWithException
	 * @return
	 */
	public static Action0 create(Action0WithException actionWithException) {
		return () -> {
			try {
				actionWithException.action();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		};
	}
}
