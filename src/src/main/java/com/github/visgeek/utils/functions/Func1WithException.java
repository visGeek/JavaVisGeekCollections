package com.github.visgeek.utils.functions;

/**
 * 引数が 1 つで戻り値があるメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
@FunctionalInterface
public interface Func1WithException<T, TResult> {
	TResult func(T arg) throws Exception;
}
