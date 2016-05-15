package com.github.visgeek.utils.functions;

/**
 * 引数が 7 つで戻り値があるメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 * @param <T4>
 * @param <T5>
 * @param <T6>
 * @param <T7>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func7WithException<T1, T2, T3, T4, T5, T6, T7, TResult> {
	TResult func(T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7) throws Exception;
}
