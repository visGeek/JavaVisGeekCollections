package com.github.visgeek.utils.functions;

/**
 * インデックスのみを引数とするメソッドを表します。
 * @param <TResult>
 */
public interface IndexedFunc0WithException<TResult> {
	TResult func(int index) throws Exception;
}
