package com.github.visgeek.utils.collections.test.testcase;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.Enumerator;
import com.github.visgeek.utils.testing.Assert2;

public class EnumeratorTest {
	@Test
	public void enumeration01() {
		Enumerator<Integer> enumerator = this.toEnumerator(1, 2, 3);

		Assert.assertTrue(enumerator.moveNext());
		Assert.assertEquals(enumerator.current(), Integer.valueOf(1));
		Assert.assertEquals(enumerator.current(), Integer.valueOf(1));
		Assert.assertTrue(enumerator.moveNext());
		Assert.assertEquals(enumerator.current(), Integer.valueOf(2));
		Assert.assertEquals(enumerator.current(), Integer.valueOf(2));
		Assert.assertTrue(enumerator.moveNext());
		Assert.assertEquals(enumerator.current(), Integer.valueOf(3));
		Assert.assertEquals(enumerator.current(), Integer.valueOf(3));
		Assert.assertFalse(enumerator.moveNext());
		Assert.assertFalse(enumerator.moveNext());
	}

	@Test
	public void enumeration02() {
		Enumerator<Integer> enumerator = this.toEnumerator(1, 2, 3);

		Assert.assertTrue(enumerator.moveNext());
		Assert.assertTrue(enumerator.moveNext());
		Assert.assertTrue(enumerator.moveNext());
		Assert.assertEquals(enumerator.current(), Integer.valueOf(3));
		Assert.assertEquals(enumerator.current(), Integer.valueOf(3));
		Assert.assertFalse(enumerator.moveNext());
		Assert.assertFalse(enumerator.moveNext());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void iteration01() {
		Enumerator<Integer> enumerator = this.toEnumerator(1, 2, 3);

		Assert.assertTrue(enumerator.hasNext());
		Assert.assertTrue(enumerator.hasNext());
		Assert.assertEquals(enumerator.next(), Integer.valueOf(1));
		Assert.assertTrue(enumerator.hasNext());
		Assert.assertTrue(enumerator.hasNext());
		Assert.assertEquals(enumerator.next(), Integer.valueOf(2));
		Assert.assertTrue(enumerator.hasNext());
		Assert.assertTrue(enumerator.hasNext());
		Assert.assertEquals(enumerator.next(), Integer.valueOf(3));
		Assert.assertFalse(enumerator.hasNext());
		Assert.assertFalse(enumerator.hasNext());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void iteration02() {
		Enumerator<Integer> enumerator = this.toEnumerator(1, 2, 3);

		Assert.assertEquals(enumerator.next(), Integer.valueOf(1));
		Assert.assertEquals(enumerator.next(), Integer.valueOf(2));
		Assert.assertEquals(enumerator.next(), Integer.valueOf(3));
		Assert2.assertExceptionThrown(NoSuchElementException.class, () -> enumerator.next());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void remove() {
		Enumerator<Integer> enumerator = this.toEnumerator(1, 2, 3);
		Assert2.assertExceptionThrown(UnsupportedOperationException.class, () -> {
			enumerator.moveNext();
			enumerator.remove();
		});
	}

	@Test
	public void empty() {
		Assert.assertEquals(false, Enumerator.empty().moveNext());
	}

	@Test
	public void create() {
		Enumerator<Integer> e = Enumerator.create(() -> 1, current -> current <= 3, current -> current + 1);
		Assert.assertEquals(true, e.moveNext());
		Assert.assertEquals(1, (int) e.current());

		Assert.assertEquals(true, e.moveNext());
		Assert.assertEquals(2, (int) e.current());

		Assert.assertEquals(true, e.moveNext());
		Assert.assertEquals(3, (int) e.current());

		Assert.assertEquals(false, e.moveNext());
	}

	private final Enumerator<Integer> toEnumerator(int... values) {
		return new Enumerator<Integer>() {
			private int index = -1;

			@Override
			public Integer current() {
				return values[this.index];
			}

			@Override
			public boolean moveNext() {
				this.index++;
				return this.index < values.length;
			}
		};
	}
}
