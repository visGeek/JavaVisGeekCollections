package com.github.visgeek.utils;

/**
 * 1 つの指定した型の値とインデックスを引数とするメソッドを表します。
 * @param <T>
 * @param <TResult>
 */
public interface IndexedFunc1WithException<T, TResult> {
	TResult func(T arg, int index) throws Exception;
}
