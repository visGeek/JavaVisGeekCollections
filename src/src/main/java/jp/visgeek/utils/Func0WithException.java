package jp.visgeek.utils;

/**
 * 引数がなく戻り値があるメソッドを表します。
 * @param <TResult>
 */
@FunctionalInterface
public interface Func0WithException<TResult> {
	TResult func() throws Exception;
}
