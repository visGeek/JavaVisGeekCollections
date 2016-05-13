package com.github.visgeek.utils.collections.test.testcase.map.enumerablelinkedmap;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.EnumerableLinkedMap;
import com.github.visgeek.utils.collections.IReadOnlyMap;

public class Constructor {
	@Test
	public void noArgs() {
		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>();

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void map() {
		LinkedHashMap<Integer, String> sourceLinkedHashMap = new LinkedHashMap<>();
		sourceLinkedHashMap.put(1, "a");
		sourceLinkedHashMap.put(2, "b");
		sourceLinkedHashMap.put(3, "c");

		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>(sourceLinkedHashMap);
		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>(sourceLinkedHashMap);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
		Assert.assertEquals(hashMap.entrySet(), enumerableMap.entrySet());
	}

	@Test
	public void initialCapacity() {
		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>(10);
		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>(10);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void initialCapacityAndLoadFactor() {
		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>(10, 0.5f, true);
		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>(10, 0.5f, true);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
		Assert.assertEquals(Constructor.getAccessOrder(hashMap), Constructor.getAccessOrder(enumerableMap));
	}

	@Test
	public void initialCapacityAndLoadFactorAndAccessOrder() {
		LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>(10, 0.5f);
		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>(10, 0.5f);

		Assert.assertEquals(Constructor.getThreshold(hashMap), Constructor.getThreshold(enumerableMap));
		Assert.assertEquals(Constructor.getLoadFactor(hashMap), Constructor.getLoadFactor(enumerableMap), 0);
	}

	@Test
	public void iReadOnlyMap() {
		EnumerableLinkedMap<Integer, String> sourceMap = new EnumerableLinkedMap<>();
		sourceMap.put(1, "a");
		sourceMap.put(2, "b");
		sourceMap.put(3, "c");

		EnumerableLinkedMap<Integer, String> enumerableMap = new EnumerableLinkedMap<>((IReadOnlyMap<Integer, String>) sourceMap);

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

	public static <K, V> boolean getAccessOrder(Map<K, V> map) {
		try {
			Field field = LinkedHashMap.class.getDeclaredField("accessOrder");
			field.setAccessible(true);
			return field.getBoolean(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
