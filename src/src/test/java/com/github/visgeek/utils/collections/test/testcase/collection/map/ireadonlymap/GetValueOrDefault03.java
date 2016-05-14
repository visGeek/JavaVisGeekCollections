package com.github.visgeek.utils.collections.test.testcase.collection.map.ireadonlymap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.testing.Assert2;

public class GetValueOrDefault03 {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void test() {
		EnumerableMap<Integer, String> map = new EnumerableMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");

		Func1<Integer, String> func =
				key -> {
					Assert.fail();
					return null;
				};

		Assert.assertEquals("a", map.getValueOrDefault(1, func));
		Assert.assertEquals("b", map.getValueOrDefault(2, func));
		Assert.assertEquals("c", map.getValueOrDefault(3, func));
		Assert.assertEquals("4", map.getValueOrDefault(4, key -> key.toString()));
		Assert.assertEquals(null, map.getValueOrDefault(5, key -> (String) null));

		// 新しいエントリーが登録されていない。
		Assert2.assertSequanceEquals(map.enumerateValues().orderByDefaultKey(), "a", "b", "c");

		// 初期値取得メソッドが null の場合はエラー。
		this.expectedException.expect(NullPointerException.class);
		Assert.assertEquals(null, map.getValueOrDefault(5, (Func1<Integer, String>) null));
	}
}
