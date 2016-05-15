package com.github.visgeek.utils.functions;

/**
 * 引数が 4 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func4WithException<T1, T2, T3, T4, TResult> {
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4) throws Exception;
}
