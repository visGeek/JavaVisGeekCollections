package com.github.visgeek.utils.collections.test.testcase.collection.set.enumerableset;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableSet;

public class Constructor {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void noArgs() {
		HashSet<Integer> hashSet = new HashSet<>();
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>();

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
	}

	@Test
	public void collectionNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Collection<Integer> collection = null;
		new EnumerableSet<>(collection);
	}

	@Test
	public void collection() {
		Collection<Integer> collection = Arrays.asList(1, 2, 3);

		HashSet<Integer> hashSet = new HashSet<>(collection);
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void iterableNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Iterable<Integer> collection = null;
		new EnumerableSet<>(collection);
	}

	@Test
	public void iterableAsCollection() {
		Iterable<Integer> collection = Arrays.asList(1, 2, 3);

		HashSet<Integer> hashSet = new HashSet<>((Collection<Integer>) collection);
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void iterableAsIterable() {
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		Iterable<Integer> collection = () -> Arrays.asList(1, 2, 3).iterator();
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void arrayNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("values");

		Integer[] collection = null;
		new EnumerableSet<>(collection);
	}

	@Test
	public void array() {
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(1, 2, 3);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void initialCapacity() {
		HashSet<Integer> hashSet = new HashSet<>(10);
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(10);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
	}

	@Test
	public void initialCapacityAndLoadFactor() {
		HashSet<Integer> hashSet = new HashSet<>(10, 0.5f);
		EnumerableSet<Integer> enumerableSet = new EnumerableSet<>(10, 0.5f);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
	}

	public static <T> int getThreshold(Set<T> set) {
		try {
			HashMap<T, Object> map = getMap(set);
			Field field = HashMap.class.getDeclaredField("threshold");
			field.setAccessible(true);
			return field.getInt(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> float getLoadFactor(Set<T> set) {
		try {
			HashMap<T, Object> map = getMap(set);
			Field field = HashMap.class.getDeclaredField("loadFactor");
			field.setAccessible(true);
			return field.getFloat(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> HashMap<T, Object> getMap(Set<T> set) {
		try {
			Field field = HashSet.class.getDeclaredField("map");
			field.setAccessible(true);
			return (HashMap<T, Object>) field.get(set);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
