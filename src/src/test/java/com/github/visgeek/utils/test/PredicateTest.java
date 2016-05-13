package com.github.visgeek.utils.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.Predicate;

public class PredicateTest {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void wrapThrowsException01() {
		Predicate<String> func = Predicate.create((arg1) -> this.throwIfNull(arg1));
		func.test("a");
	}

	@Test
	public void wrapThrowsException02() {
		this.expectedException.expect(Exception.class);

		Predicate<String> func = Predicate.create((arg1) -> this.throwIfNull(arg1));
		func.test(null);
	}

	private boolean throwIfNull(String str) throws Exception {
		if (str == null) {
			throw new Exception();
		} else {
			return true;
		}
	}
}
