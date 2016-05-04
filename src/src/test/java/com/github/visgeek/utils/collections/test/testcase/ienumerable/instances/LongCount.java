package com.github.visgeek.utils.collections.test.testcase.ienumerable.instances;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import com.github.visgeek.utils.collections.AbstractEnumerator;
import com.github.visgeek.utils.collections.IEnumerable;

public class LongCount {
	public static void main(String[] args) {
		new LongCount().LongCount01_01();
		// new LongCount().LongCount01_02();
		// new LongCount().LongCount02_01();
		// new LongCount().LongCount02_02();
	}

	@Test
	public void LongCount01_01() {
		long expected = (long) Integer.MAX_VALUE + 1L;

		IEnumerable<String> values =
				new IEnumerable<String>() {
					@Override
					public Iterator<String> iterator() {
						return new AbstractEnumerator<String>() {
							private long i = 0;

							@Override
							public String current() {
								return null;
							}

							@Override
							public boolean moveNext() {
								this.i++;
								return this.i <= expected;
							}
						};
					}
				};

		long actual = values.longCount();

		Assert.assertEquals(expected, actual);
	}

	// @Test
	// public void LongCount01_02() {
	// IEnumerable<String> values =
	// new IEnumerable<String>() {
	// @Override
	// public Iterator<String> iterator() {
	// return new AbstractEnumerator<String>() {
	// private long i = -100;
	//
	// @Override
	// public String current() {
	// return null;
	// }
	//
	// @Override
	// public boolean moveNext() {
	// this.i++;
	// return this.i <= Long.MAX_VALUE;
	// }
	// };
	// }
	// };
	//
	// try {
	// values.longCount();
	// Assert.fail();
	// } catch (Exception e) {
	// //
	// }
	// }
	//
	// @Test
	// public void LongCount02_01() {
	// long valueCount = (long) Integer.MAX_VALUE * 2 + 1L;
	// long expected = valueCount / 2L;
	//
	// IEnumerable<Long> values =
	// new IEnumerable<Long>() {
	// @Override
	// public Iterator<Long> iterator() {
	// return new AbstractEnumerator<Long>() {
	// private long i = 0;
	//
	// @Override
	// public Long current() {
	// return this.i;
	// }
	//
	// @Override
	// public boolean moveNext() {
	// this.i++;
	// return this.i <= valueCount;
	// }
	// };
	// }
	// };
	//
	// long actual = values.longCount(n -> n % 2 == 0);
	//
	// Assert.assertEquals(expected, actual);
	// }
	//
	// @Test
	// public void LongCount02_02() {
	// IEnumerable<String> values =
	// new IEnumerable<String>() {
	// @Override
	// public Iterator<String> iterator() {
	// return new AbstractEnumerator<String>() {
	// private long i = -100;
	//
	// @Override
	// public String current() {
	// return null;
	// }
	//
	// @Override
	// public boolean moveNext() {
	// this.i++;
	// return this.i <= Long.MAX_VALUE;
	// }
	// };
	// }
	// };
	//
	// try {
	// values.longCount();
	// Assert.fail();
	// } catch (Exception e) {
	// //
	// }
	// }
}
