package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action0;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.Func2;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class MaxNumber {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		//@formatter:off
		this.test(Integer::parseInt   , (enumerable, selector) -> enumerable.maxInt   (selector), 3   , "2"  , "1"  , null, "3"  );
		this.test(Long   ::parseLong  , (enumerable, selector) -> enumerable.maxLong  (selector), 3L  , "2"  , "1"  , null, "3"  );
		this.test(Double ::parseDouble, (enumerable, selector) -> enumerable.maxDouble(selector), 3.0 , "2.0", "1.0", null, "3.0");
		this.test(Float  ::parseFloat , (enumerable, selector) -> enumerable.maxFloat (selector), 3.0f, "2.0", "1.0", null, "3.0");
		this.test(str -> BigDecimal.valueOf(Long.parseLong(str)), (enumerable, selector) -> enumerable.maxBigDecimal(selector), BigDecimal.valueOf(3L), "2", "1", null, "3");
		//@formatter:on
	}

	private <T> void test(Func1<String, T> selector, Func2<IEnumerable<String>, Func1<String, T>, T> testFunc, T expected, String... source) {
		Func1<String, T> selector2 = str -> str == null ? null : selector.func(str);
		this.argIsNull(testFunc);
		this.empty(selector2, testFunc);
		this.normal(selector2, testFunc, expected, source);
	}

	private <T> void argIsNull(Func2<IEnumerable<String>, Func1<String, T>, T> testFunc) {

		String[] source = CollectionCreator.emptyAarray();

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		Action0 action = () -> testFunc.func(enumerable, null);

		Assert2.assertNullPointerExceptionThrown("selector", action);
	}

	public <T> void empty(
			Func1<String, T> selector,
			Func2<IEnumerable<String>, Func1<String, T>, T> testFunc) {

		String[] source = new String[] {};
		Double expected = null;

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		T actual = testFunc.func(enumerable, selector);

		Assert.assertEquals(expected, actual);
	}

	public <T> void normal(
			Func1<String, T> selector,
			Func2<IEnumerable<String>, Func1<String, T>, T> testFunc,
			T expected,
			String... source) {

		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		T actual = testFunc.func(enumerable, selector);

		Assert.assertEquals(expected, actual);
	}
}
