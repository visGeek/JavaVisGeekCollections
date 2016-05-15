package com.github.visgeek.utils.functions;

@FunctionalInterface
public interface PredicateWithException<T> {
	boolean test(T arg) throws Exception;
}
