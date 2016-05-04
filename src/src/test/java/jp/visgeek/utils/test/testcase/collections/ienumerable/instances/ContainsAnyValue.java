package jp.visgeek.utils.test.testcase.collections.ienumerable.instances;

import org.junit.Assert;
import org.junit.Test;

import jp.visgeek.utils.IEqualityComparator;
import jp.visgeek.utils.collections.Enumerable;
import jp.visgeek.utils.collections.IEnumerable;

public class ContainsAnyValue {
	@Test
	public void test_containsAnyValue01_01() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.of(2, 3, 4);

		boolean actual = values1.containsAnyValue(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_containsAnyValue01_02() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.of(2, 6, 7, 8);

		boolean actual = values1.containsAnyValue(values2);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_containsAnyValue01_03() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.of(6, 7, 8);

		boolean actual = values1.containsAnyValue(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_containsAnyValue01_04() {
		IEnumerable<Integer> values1 = Enumerable.of(1, 2, 3, 4, 5);
		IEnumerable<Integer> values2 = Enumerable.empty();

		boolean actual = values1.containsAnyValue(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_containsAnyValue01_05() {
		IEnumerable<Integer> values1 = Enumerable.empty();
		IEnumerable<Integer> values2 = Enumerable.empty();

		boolean actual = values1.containsAnyValue(values2);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_containsAnyValue02_01() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.of("2", "3", "4");

		boolean actual = values1.containsAnyValue(values2, eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_containsAnyValue02_02() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.of("2", "6", "7", "8");

		boolean actual = values1.containsAnyValue(values2, eComparator);
		Assert.assertTrue(actual);
	}

	@Test
	public void test_containsAnyValue02_03() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.of("6", "7", "8");

		boolean actual = values1.containsAnyValue(values2, eComparator);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_containsAnyValue02_04() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.of("01", "02", "03", "04", "05");
		IEnumerable<String> values2 = Enumerable.empty();

		boolean actual = values1.containsAnyValue(values2, eComparator);
		Assert.assertFalse(actual);
	}

	@Test
	public void test_containsAnyValue02_05() {
		IEqualityComparator<String> eComparator =
				IEqualityComparator.create(
						obj -> Integer.parseInt(obj),
						(a, b) -> Integer.parseInt(a) == Integer.parseInt(b));

		IEnumerable<String> values1 = Enumerable.empty();
		IEnumerable<String> values2 = Enumerable.empty();

		boolean actual = values1.containsAnyValue(values2, eComparator);
		Assert.assertFalse(actual);
	}
}
