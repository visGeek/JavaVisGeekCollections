package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;

public class LastOrDefault {
	@Test
	public void test_lastOrDefault01() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault();
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_lastOrDefault02() {
		Integer actual = Enumerable.empty(Integer.class).lastOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault03() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault(4);
		Assert.assertEquals(3, actual);
	}

	@Test
	public void test_lastOrDefault04() {
		int actual = Enumerable.empty(Integer.class).lastOrDefault(4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_lastOrDefault05() {
		int actual = Enumerable.of(1, 2, 3, 4, 5).lastOrDefault(arg -> arg % 2 == 0);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_lastOrDefault06() {
		Integer actual = Enumerable.of(1, 2, 3).lastOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault07() {
		Integer actual = Enumerable.empty(Integer.class).lastOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_lastOrDefault08() {
		int actual = Enumerable.of(1, 2, 3).lastOrDefault(arg -> arg == 4, 5);
		Assert.assertEquals(5, actual);
	}
}
