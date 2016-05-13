package com.github.visgeek.utils;

@FunctionalInterface
public interface IndexedPredicateWithException<T> {
	boolean test(T t, int index) throws Exception;
}
