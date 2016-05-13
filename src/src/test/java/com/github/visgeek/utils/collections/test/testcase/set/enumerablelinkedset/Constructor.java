package com.github.visgeek.utils.collections.test.testcase.set.enumerablelinkedset;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableLinkedSet;

public class Constructor {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void noArgs() {
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>();

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
	}

	@Test
	public void collectionNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Collection<Integer> collection = null;
		new EnumerableLinkedSet<>(collection);
	}

	@Test
	public void collection() {
		Collection<Integer> collection = Arrays.asList(1, 2, 3);

		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(collection);
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void iterableNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		Iterable<Integer> collection = null;
		new EnumerableLinkedSet<>(collection);
	}

	@Test
	public void iterableAsCollection() {
		Iterable<Integer> collection = Arrays.asList(1, 2, 3);

		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>((Collection<Integer>) collection);
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void iterableAsIterable() {
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		Iterable<Integer> collection = () -> Arrays.asList(1, 2, 3).iterator();
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(collection);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void arrayNullArg() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("values");

		Integer[] collection = null;
		new EnumerableLinkedSet<>(collection);
	}

	@Test
	public void array() {
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);

		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(1, 2, 3);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
		Assert.assertEquals(hashSet, enumerableSet);
	}

	@Test
	public void initialCapacity() {
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(10);
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(10);

		Assert.assertEquals(Constructor.getThreshold(hashSet), Constructor.getThreshold(enumerableSet));
		Assert.assertEquals(Constructor.getLoadFactor(hashSet), Constructor.getLoadFactor(enumerableSet), 0);
	}

	@Test
	public void initialCapacityAndLoadFactor() {
		LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(10, 0.5f);
		EnumerableLinkedSet<Integer> enumerableSet = new EnumerableLinkedSet<>(10, 0.5f);

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
