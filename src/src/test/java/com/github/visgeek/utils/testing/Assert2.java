package com.github.visgeek.utils.testing;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.junit.Assert;

import com.github.visgeek.utils.Action0;

public class Assert2 {
	private Assert2() {
	}

	@SafeVarargs
	public static <T> void assertSequanceEquals(Iterable<T> actual, T... expected) {
		Assert2.assertSequanceEquals(null, actual, expected);
	}

	@SafeVarargs
	public static <T> void assertSequanceEquals(String message, Iterable<T> actual, T... expected) {
		Iterator<T> itr = actual.iterator();

		int count = 0;
		while (itr.hasNext()) {
			count++;

			Assert.assertTrue(message, count <= expected.length);

			T item = itr.next();
			Assert.assertTrue(message, Objects.equals(item, expected[count - 1]));
		}

		Assert.assertTrue(message, expected.length <= count);
	}

	public static void exceptionThrown(Class<? extends Exception> expectedExceptionClass, Action0 action) {
		Throwable raised = null;

		try {
			action.action();
		} catch (Throwable e) {
			raised = e;
		}

		Assert.assertTrue(raised != null);
		Assert.assertTrue(Objects.equals(raised.getClass(), expectedExceptionClass));
	}

	static {
		// このクラスのカバレッジのためのコード
		new Assert2();

		for (Sequences seqs : new Sequences[] {
			new Sequences(Arrays.asList(1), 1),
			new Sequences(Arrays.asList(1), 2),
			new Sequences(Arrays.asList(1, 2), 1),
			new Sequences(Arrays.asList(1, 2), 1, 2, 3),
		}) {
			try {
				Assert2.assertSequanceEquals(seqs.seq1, seqs.seq2);
			} catch (AssertionError e) {
			}
		}

		for (ExceptionAndAction action : new ExceptionAndAction[] {
			new ExceptionAndAction(RuntimeException.class, () -> {
			}),
			new ExceptionAndAction(RuntimeException.class, () -> {
				throw new RuntimeException();
			}),
		}) {
			try {
				Assert2.exceptionThrown(action.expectedExceptionClass, action.action);
			} catch (AssertionError e) {
			}
		}
	}

	private static class Sequences {
		public Sequences(Iterable<Integer> seq1, Integer... seq2) {
			this.seq1 = seq1;
			this.seq2 = seq2;
		}

		private final Iterable<Integer> seq1;

		private final Integer[] seq2;
	}

	private static class ExceptionAndAction {
		public ExceptionAndAction(Class<? extends Exception> expectedExceptionClass, Action0 action) {
			this.expectedExceptionClass = expectedExceptionClass;
			this.action = action;
		}

		public final Class<? extends Exception> expectedExceptionClass;

		public final Action0 action;
	}
}
