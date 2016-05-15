package com.github.visgeek.utils.functions;

@FunctionalInterface
public interface IndexedPredicateWithException<T> {
	boolean test(T t, int index) throws Exception;
}
