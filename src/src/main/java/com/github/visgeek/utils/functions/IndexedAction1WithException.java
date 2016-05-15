package com.github.visgeek.utils.functions;

/**
 * 1 つの指定した型の値とインデックスを引数とする戻り値がないメソッドを表します。
 * @param <T>
 */
@FunctionalInterface
public interface IndexedAction1WithException<T> {
	void action(T arg, int index) throws Exception;
}
