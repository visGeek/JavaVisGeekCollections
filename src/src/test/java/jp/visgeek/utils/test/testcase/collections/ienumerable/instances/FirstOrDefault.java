package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.collections.Enumerable;

public class FirstOrDefault {
	@Test
	public void test_firstOrDefault02() {
		Integer actual = Enumerable.empty(Integer.class).firstOrDefault();
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault03() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(4);
		Assert.assertEquals(1, actual);
	}

	@Test
	public void test_firstOrDefault04() {
		int actual = Enumerable.empty(Integer.class).firstOrDefault(4);
		Assert.assertEquals(4, actual);
	}

	@Test
	public void test_firstOrDefault05() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 2);
		Assert.assertEquals(2, actual);
	}

	@Test
	public void test_firstOrDefault06() {
		Integer actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault07() {
		Integer actual = Enumerable.empty(Integer.class).firstOrDefault(arg -> arg == 4);
		Assert.assertEquals(null, actual);
	}

	@Test
	public void test_firstOrDefault08() {
		int actual = Enumerable.of(1, 2, 3).firstOrDefault(arg -> arg == 4, 5);
		Assert.assertEquals(5, actual);
	}
}
