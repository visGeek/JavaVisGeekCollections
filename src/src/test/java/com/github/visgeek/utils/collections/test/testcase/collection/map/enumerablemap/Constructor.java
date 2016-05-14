package com.github.visgeek.utils.collections.test.testcase.collection.map.enumerablemap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableMap;
import com.github.visgeek.utils.collections.IReadOnlyMap;

public class Constructor {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void noArgs() {
		HashMap<Integer, String> hashMap = new HashMap<>();
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>();

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void mapNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("map");

		Map<Integer, String> map = null;
		new EnumerableMap<>(map);
	}

	@Test
	public void map() {
		HashMap<Integer, String> sourceHashMap = new HashMap<>();
		sourceHashMap.put(1, "a");
		sourceHashMap.put(2, "b");
		sourceHashMap.put(3, "c");

		HashMap<Integer, String> hashMap = new HashMap<>(sourceHashMap);
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>(sourceHashMap);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
		Assert.assertEquals(hashMap.entrySet(), enumerableMap.entrySet());
	}

	@Test
	public void initialCapacity() {
		HashMap<Integer, String> hashMap = new HashMap<>(10);
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>(10);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void initialCapacityAndLoadFactor() {
		HashMap<Integer, String> hashMap = new HashMap<>(10, 0.5f);
		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>(10, 0.5f);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void iReadOnlyMapNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("map");

		IReadOnlyMap<Integer, String> map = null;
		new EnumerableMap<>(map);
	}

	@Test
	public void iReadOnlyMap() {
		EnumerableMap<Integer, String> sourceMap = new EnumerableMap<>();
		sourceMap.put(1, "a");
		sourceMap.put(2, "b");
		sourceMap.put(3, "c");

		EnumerableMap<Integer, String> enumerableMap = new EnumerableMap<>((IReadOnlyMap<Integer, String>) sourceMap);

		Assert.assertEquals(Constructor.getThreshold(sourceMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(sourceMap), Constructor.getLoadFactor(enumerableMap), 0);
		Assert.assertEquals(sourceMap.entrySet(), enumerableMap.entrySet());
	}

	public static <K, V> int getThreshold(Map<K, V> map) {
		try {
			Field field = HashMap.class.getDeclaredField("threshold");
			field.setAccessible(true);
			return field.getInt(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <K, V> float getLoadFactor(Map<K, V> map) {
		try {
			Field field = HashMap.class.getDeclaredField("loadFactor");
			field.setAccessible(true);
			return field.getFloat(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
