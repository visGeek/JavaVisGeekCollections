package com.github.visgeek.utils.functions;

/**
 * 引数が 2 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 */
@FunctionalInterface
public interface Action2WithException<T1, T2> {
	void action(T1 arg1, T2 arg2) throws Exception;
}
