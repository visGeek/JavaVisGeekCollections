package com.github.visgeek.utils;

/**
 * 引数が 3 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
@FunctionalInterface
public interface Action3WithException<T1, T2, T3> {
	void action(T1 arg1, T2 arg2, T3 arg3) throws Exception;
}
