package com.github.visgeek.utils.functions;

/**
 * 引数が 3 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func3WithException<T1, T2, T3, TResult> {
	TResult func(T1 arg1, T2 arg2, T3 arg3) throws Exception;
}
