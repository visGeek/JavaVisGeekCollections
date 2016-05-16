package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.math.BigDecimal;

import org.junit.Test;

import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.functions.Action1;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.IndexedFunc1;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class Select {
	@Test
	public void test() {
		// Object
		this.selectorIsNull(src -> src.select((Func1<String, Integer>) null));
		this.success(new String[] { "1", "2", "3" }, new Integer[] { 1, 2, 3 }, src -> src.select(str -> Integer.parseInt(str)));

		this.selectorIsNull(src -> src.select((IndexedFunc1<String, Integer>) null));
		this.success(new String[] { "1", "2", "3" }, new String[] { "0:1", "1:2", "2:3" }, src -> src.select(this::indexedSelector));

		// Integer
		this.selectorIsNull(src -> src.selectInteger(null));
		this.success(new String[] { "1", "2", "3" }, new Integer[] { 1, 2, 3 }, src -> src.selectInteger(Integer::parseInt));

		// Long
		this.selectorIsNull(src -> src.selectLong(null));
		this.success(new String[] { "1", "2", "3" }, new Long[] { 1L, 2L, 3L }, src -> src.selectLong(Long::parseLong));

		// FLoat
		this.selectorIsNull(src -> src.selectFloat(null));
		this.success(new String[] { "1.0", "2.0", "3.0" }, new Float[] { 1.0f, 2.0f, 3.0f }, src -> src.selectFloat(Float::parseFloat));

		// Double
		this.selectorIsNull(src -> src.selectDouble(null));
		this.success(new String[] { "1.0", "2.0", "3.0" }, new Double[] { 1.0, 2.0, 3.0 }, src -> src.selectDouble(Double::parseDouble));

		// Short
		this.selectorIsNull(src -> src.selectShort(null));
		this.success(new String[] { "1", "2", "3" }, new Short[] { 1, 2, 3 }, src -> src.selectShort(Short::parseShort));

		// Byte
		this.selectorIsNull(src -> src.selectByte(null));
		this.success(new String[] { "1", "2", "3" }, new Byte[] { 1, 2, 3 }, src -> src.selectByte(Byte::parseByte));

		// Character
		this.selectorIsNull(src -> src.selectCharacter(null));
		this.success(new String[] { "a", "b", "c" }, new Character[] { 'a', 'b', 'c' }, src -> src.selectCharacter(str -> str.charAt(0)));

		// Boolean
		this.selectorIsNull(src -> src.selectBoolean(null));
		this.success(new String[] { "false", "true", "true" }, new Boolean[] { false, true, true }, src -> src.selectBoolean(Boolean::parseBoolean));

		// BigDecimal
		this.selectorIsNull(src -> src.selectBigDecimal(null));
		this.success(new String[] { "1", "2", "3" }, new BigDecimal[] { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3) }, src -> src.selectBigDecimal(str -> BigDecimal.valueOf(Long.parseLong(str))));
	}

	private void selectorIsNull(Action1<IEnumerable<String>> action) {
		IEnumerable<String> enumerable = () -> CollectionCreator.iterator();
		Assert2.assertNullPointerExceptionThrown("selector", action.partialApply(enumerable));
	}

	private <T, TEnumerable extends IEnumerable<T>> void success(String[] source, T[] expected, Func1<IEnumerable<String>, TEnumerable> selectMethod) {
		IEnumerable<String> enumerable = () -> CollectionCreator.iterator(source);
		TEnumerable actual = selectMethod.func(enumerable);
		Assert2.assertSequanceEquals(actual, expected);
	}

	private String indexedSelector(String str, int index) {
		return String.format("%d:%s", index, str);
	}
}
