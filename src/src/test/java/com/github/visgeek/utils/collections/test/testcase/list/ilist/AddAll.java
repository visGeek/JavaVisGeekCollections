package com.github.visgeek.utils.collections.test.testcase.list.ilist;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.visgeek.utils.collections.EnumerableList;
import com.github.visgeek.utils.testing.Assert2;

public class AddAll {
	@Rule
	public final ExpectedException expectedException = ExpectedException.none();

	@Test
	public void argIsNull() {
		this.expectedException.expect(NullPointerException.class);
		this.expectedException.expectMessage("collection");

		EnumerableList<Integer> set = new EnumerableList<>();
		set.addAll((Iterable<Integer>) null);
	}

	@Test
	public void addAll01() {
		Collection<Integer> collectionAsCollection = Arrays.asList(1, 2, 3);
		Iterable<Integer> iterableAsCollection = collectionAsCollection;
		Iterable<Integer> iterableAsIterable = () -> collectionAsCollection.iterator();

		EnumerableList<Integer> listForCollectionAsCollection = new EnumerableList<>();
		EnumerableList<Integer> listForIterableAsCollection = new EnumerableList<>();
		EnumerableList<Integer> listForIterableAsIterable = new EnumerableList<>();

		for (int i = 1; i <= 3; i++) {
			boolean addAllExpected = listForCollectionAsCollection.addAll(collectionAsCollection);
			boolean addAllResult1 = listForIterableAsCollection.addAll(iterableAsCollection);
			boolean addAllResult2 = listForIterableAsIterable.addAll(iterableAsIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, addAllExpected, addAllResult1);
			Assert.assertEquals(message, addAllExpected, addAllResult2);

			Assert2.assertSequanceEquals(message, listForIterableAsCollection, listForCollectionAsCollection);
			Assert2.assertSequanceEquals(message, listForIterableAsIterable, listForCollectionAsCollection);
		}
	}

	@Test
	public void addAll02() {
		Collection<Integer> collectionAsCollection = Arrays.asList(2, 3, 4);
		Iterable<Integer> iterableAsCollection = collectionAsCollection;
		Iterable<Integer> iterableAsIterable = () -> collectionAsCollection.iterator();

		EnumerableList<Integer> listForCollectionAsCollection = new EnumerableList<>(1, 5);
		EnumerableList<Integer> listForIterableAsCollection = listForCollectionAsCollection.clone();
		EnumerableList<Integer> listForIterableAsIterable = listForCollectionAsCollection.clone();

		for (int i = 1; i <= 3; i++) {
			boolean addAllExpected = listForCollectionAsCollection.addAll(2, collectionAsCollection);
			boolean addAllActual1 = listForIterableAsCollection.addAll(2, iterableAsCollection);
			boolean addAllActual2 = listForIterableAsIterable.addAll(2, iterableAsIterable);

			String message = String.format("%d回目", i);

			Assert.assertEquals(message, addAllExpected, addAllActual1);
			Assert.assertEquals(message, addAllExpected, addAllActual2);

			Assert2.assertSequanceEquals(message, listForIterableAsCollection, listForCollectionAsCollection);
			Assert2.assertSequanceEquals(message, listForIterableAsIterable, listForCollectionAsCollection);
		}
	}
}
