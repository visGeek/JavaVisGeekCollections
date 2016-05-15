package com.github.visgeek.utils.functions;

/**
 * 引数が 2 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func2WithException<T1, T2, TResult> {
	TResult func(T1 arg1, T2 arg2) throws Exception;
}
