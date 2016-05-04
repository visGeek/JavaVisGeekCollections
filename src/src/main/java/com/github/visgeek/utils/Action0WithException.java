package com.github.visgeek.utils;

/**
 * 引数と戻り値がないメソッドを表します。
 */
@FunctionalInterface
public interface Action0WithException {
	void action() throws Exception;
}
