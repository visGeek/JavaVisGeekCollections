package com.github.visgeek.utils.collections.test.testcase;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.testing.Assert2;

public class AbstractEnumeratorTest {
	private final AbstractEnumerator<Integer> create(int... values) {
		return new AbstractEnumerator<Integer>() {
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

	@Test
	public void iterable() {
		Iterable<Integer> values = () -> this.create(1, 2, 3);
		Assert2.assertSequanceEquals(values, 1, 2, 3);
	}

	@Test
	public void enumeration01() {
		AbstractEnumerator<Integer> enumerator = this.create(1, 2, 3);

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
		AbstractEnumerator<Integer> enumerator = this.create(1, 2, 3);

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
		AbstractEnumerator<Integer> enumerator = this.create(1, 2, 3);

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
		AbstractEnumerator<Integer> enumerator = this.create(1, 2, 3);

		Assert.assertEquals(enumerator.next(), Integer.valueOf(1));
		Assert.assertEquals(enumerator.next(), Integer.valueOf(2));
		Assert.assertEquals(enumerator.next(), Integer.valueOf(3));
		Assert2.exceptionThrown(NoSuchElementException.class, () -> enumerator.next());
	}

	@Test
	@SuppressWarnings("deprecation")
	public void remove() {
		AbstractEnumerator<Integer> enumerator = this.create(1, 2, 3);
		Assert2.exceptionThrown(UnsupportedOperationException.class, () -> {
			enumerator.moveNext();
			enumerator.remove();
		});
	}
}
