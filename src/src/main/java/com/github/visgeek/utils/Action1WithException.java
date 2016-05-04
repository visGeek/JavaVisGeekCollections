package com.github.visgeek.utils;

/**
 * 引数が 1 つで戻り値がないメソッドを表します。
 * @param <T1>
 * @param <T2>
 */
@FunctionalInterface
public interface Action1WithException<T> {
	void action(T arg) throws Exception;
}
