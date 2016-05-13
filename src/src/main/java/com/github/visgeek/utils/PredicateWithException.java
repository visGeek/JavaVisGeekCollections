package com.github.visgeek.utils;

@FunctionalInterface
public interface PredicateWithException<T> {
	boolean test(T arg) throws Exception;
}
