package com.github.visgeek.utils.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.IndexedPredicate;

public class IndexedPredicateTest {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void wrapThrowsException01() {
		IndexedPredicate<String> func = IndexedPredicate.create((arg1, index) -> this.throwIfNull(arg1));
		func.test("a", 0);
	}

	@Test
	public void wrapThrowsException02() {
		this.expectedException.expect(Exception.class);

		IndexedPredicate<String> func = IndexedPredicate.create((arg1, index) -> this.throwIfNull(arg1));
		func.test(null, 0);
	}

	private boolean throwIfNull(String str) throws Exception {
		if (str == null) {
			throw new Exception();
		} else {
			return true;
		}
	}
}
