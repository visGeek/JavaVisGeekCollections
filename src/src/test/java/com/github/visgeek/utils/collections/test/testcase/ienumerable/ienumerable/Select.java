package com.github.visgeek.utils.collections.test.testcase.ienumerable.ienumerable;

import java.math.BigDecimal;

import org.junit.Test;

import com.github.visgeek.utils.collections.IBooleanEnumerable;
import com.github.visgeek.utils.collections.IByteEnumerable;
import com.github.visgeek.utils.collections.ICharacterEnumerable;
import com.github.visgeek.utils.collections.IDoubleEnumerable;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.collections.IFloatEnumerable;
import com.github.visgeek.utils.collections.IIntegerEnumerable;
import com.github.visgeek.utils.collections.ILongEnumerable;
import com.github.visgeek.utils.collections.IShortEnumerable;
import com.github.visgeek.utils.collections.test.testcase.enumerable.of.IBigDecimalEnumerable;
import com.github.visgeek.utils.functions.Action1;
import com.github.visgeek.utils.functions.Func1;
import com.github.visgeek.utils.functions.IndexedFunc1;
import com.github.visgeek.utils.testing.Assert2;
import com.github.visgeek.utils.testing.CollectionCreator;

public class Select {
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		// Object
		this.selectorIsNull(IEnumerable.class, src -> src.select((Func1<String, Integer>) null));
		this.success(IEnumerable.class, new String[] { "1", "2", "3" }, new Integer[] { 1, 2, 3 }, src -> src.select(str -> Integer.parseInt(str)));

		this.selectorIsNull(IEnumerable.class, src -> src.select((IndexedFunc1<String, Integer>) null));
		this.success(IEnumerable.class, new Integer[] { 1, 2, 3 }, new String[] { "0:1", "1:2", "2:3" }, src -> src.select((value, index) -> String.format("%d:%s", index, value)));

		// Integer
		this.selectorIsNull(IIntegerEnumerable.class, src -> src.selectInteger((Func1<String, Integer>) null));
		this.success(IIntegerEnumerable.class, new String[] { "1", "2", "3" }, new Integer[] { 1, 2, 3 }, src -> src.selectInteger(str -> Integer.parseInt(str)));

		this.selectorIsNull(IIntegerEnumerable.class, src -> src.selectInteger((IndexedFunc1<String, Integer>) null));
		this.success(IIntegerEnumerable.class, new Integer[] { 1, 2, 3 }, new Integer[] { 0 * 1, 1 * 2, 2 * 3 }, src -> src.selectInteger((value, index) -> value * index));

		// Long
		this.selectorIsNull(ILongEnumerable.class, src -> src.selectLong((Func1<String, Long>) null));
		this.success(ILongEnumerable.class, new String[] { "1", "2", "3" }, new Long[] { 1L, 2L, 3L }, src -> src.selectLong(str -> Long.parseLong(str)));

		this.selectorIsNull(ILongEnumerable.class, src -> src.selectLong((IndexedFunc1<String, Long>) null));
		this.success(ILongEnumerable.class, new Long[] { 1L, 2L, 3L }, new Long[] { 0 * 1L, 1 * 2L, 2 * 3L }, src -> src.selectLong((value, index) -> value * index));

		// FLoat
		this.selectorIsNull(IFloatEnumerable.class, src -> src.selectFloat((Func1<String, Float>) null));
		this.success(IFloatEnumerable.class, new String[] { "1.0", "2.0", "3.0" }, new Float[] { 1.0f, 2.0f, 3.0f }, src -> src.selectFloat(str -> Float.parseFloat(str)));

		this.selectorIsNull(IFloatEnumerable.class, src -> src.selectFloat((IndexedFunc1<String, Float>) null));
		this.success(IFloatEnumerable.class, new Float[] { 1.0f, 2.0f, 3.0f }, new Float[] { 0 * 1.0f, 1 * 2.0f, 2 * 3.0f }, src -> src.selectFloat((value, index) -> value * index));

		// Double
		this.selectorIsNull(IDoubleEnumerable.class, src -> src.selectDouble((Func1<String, Double>) null));
		this.success(IDoubleEnumerable.class, new String[] { "1.0", "2.0", "3.0" }, new Double[] { 1.0, 2.0, 3.0 }, src -> src.selectDouble(str -> Double.parseDouble(str)));

		this.selectorIsNull(IDoubleEnumerable.class, src -> src.selectDouble((IndexedFunc1<String, Double>) null));
		this.success(IDoubleEnumerable.class, new Double[] { 1.0, 2.0, 3.0 }, new Double[] { 0 * 1.0, 1 * 2.0, 2 * 3.0 }, src -> src.selectDouble((value, index) -> value * index));

		// Short
		this.selectorIsNull(IShortEnumerable.class, src -> src.selectShort((Func1<String, Short>) null));
		this.success(IShortEnumerable.class, new String[] { "1", "2", "3" }, new Short[] { 1, 2, 3 }, src -> src.selectShort(str -> Short.parseShort(str)));

		this.selectorIsNull(IShortEnumerable.class, src -> src.selectShort((IndexedFunc1<String, Short>) null));
		this.success(IShortEnumerable.class, new Short[] { 1, 2, 3 }, new Short[] { 0 * 1, 1 * 2, 2 * 3 }, src -> src.selectShort((value, index) -> (short) (value * index)));

		// Byte
		this.selectorIsNull(IByteEnumerable.class, src -> src.selectByte((Func1<String, Byte>) null));
		this.success(IByteEnumerable.class, new String[] { "1", "2", "3" }, new Byte[] { 1, 2, 3 }, src -> src.selectByte(str -> Byte.parseByte(str)));

		this.selectorIsNull(IByteEnumerable.class, src -> src.selectByte((IndexedFunc1<String, Byte>) null));
		this.success(IByteEnumerable.class, new Byte[] { 1, 2, 3 }, new Byte[] { 0 * 1, 1 * 2, 2 * 3 }, src -> src.selectByte((value, index) -> (byte) (value * index)));

		// Character
		this.selectorIsNull(ICharacterEnumerable.class, src -> src.selectCharacter((Func1<String, Character>) null));
		this.success(ICharacterEnumerable.class, new String[] { "a", "b", "c" }, new Character[] { 'a', 'b', 'c' }, src -> src.selectCharacter(str -> str.charAt(0)));

		this.selectorIsNull(ICharacterEnumerable.class, src -> src.selectCharacter((IndexedFunc1<String, Character>) null));
		this.success(ICharacterEnumerable.class, new Character[] { 'a', 'b', 'c' }, new Character[] { 0 * 'a', 1 * 'b', 2 * 'c' }, src -> src.selectCharacter((value, index) -> (char) (value * index)));

		// Boolean
		this.selectorIsNull(IBooleanEnumerable.class, src -> src.selectBoolean((Func1<String, Boolean>) null));
		this.success(IBooleanEnumerable.class, new String[] { "false", "true", "true" }, new Boolean[] { false, true, true }, src -> src.selectBoolean(str -> Boolean.parseBoolean(str)));

		this.selectorIsNull(IBooleanEnumerable.class, src -> src.selectBoolean((IndexedFunc1<String, Boolean>) null));
		this.success(IBooleanEnumerable.class, new Integer[] { 0, 1, 3 }, new Boolean[] { true, true, false }, src -> src.selectBoolean((value, index) -> value == index));

		// BigDecimal
		this.selectorIsNull(IBigDecimalEnumerable.class, src -> src.selectBigDecimal((Func1<String, BigDecimal>) null));
		this.success(IBigDecimalEnumerable.class, new Integer[] { 1, 2, 3 }, new BigDecimal[] { BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3) }, src -> src.selectBigDecimal(value -> BigDecimal.valueOf(value)));

		this.selectorIsNull(IBigDecimalEnumerable.class, src -> src.selectBigDecimal((IndexedFunc1<String, BigDecimal>) null));
		this.success(IBigDecimalEnumerable.class, new Integer[] { 1, 2, 3 }, new BigDecimal[] { BigDecimal.valueOf(0 * 1), BigDecimal.valueOf(1 * 2), BigDecimal.valueOf(2 * 3) }, src -> src.selectBigDecimal((value, index) -> BigDecimal.valueOf(value * index)));
	}

	private <TEnumerable extends IEnumerable<?>> void selectorIsNull(Class<TEnumerable> enumerableClass, Action1<IEnumerable<String>> action) {
		IEnumerable<String> enumerable = () -> CollectionCreator.iterator();
		Assert2.assertNullPointerExceptionThrown("selector", action.partialApply(enumerable));
	}

	private <TSource, TResult, TEnumerable extends IEnumerable<TResult>> void success(
			Class<TEnumerable> enumerableClass,
			TSource[] source,
			TResult[] expected,
			Func1<IEnumerable<TSource>, TEnumerable> selectMethod) {

		IEnumerable<TSource> enumerable = () -> CollectionCreator.iterator(source);
		TEnumerable actual = selectMethod.func(enumerable);
		Assert2.assertSequanceEquals(actual, expected);
	}
}
