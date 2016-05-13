package com.github.visgeek.utils;

/**
 * インデックスのみを引数とする戻り値がないメソッドを表します。
 */
@FunctionalInterface
public interface IndexedAction0WithException {
	void action(int index) throws Exception;
}
