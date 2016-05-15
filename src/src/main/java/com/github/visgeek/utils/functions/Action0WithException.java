package com.github.visgeek.utils.functions;

/**
 * 引数と戻り値がないメソッドを表します。
 */
@FunctionalInterface
public interface Action0WithException {
	void action() throws Exception;
}
