package jp.visgeek.utils.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import jp.visgeek.utils.Func0;
import jp.visgeek.utils.Func1;

public final class Enumerable {
	// コンストラクター
	private Enumerable() {
	}

	// スタティックメソッド
	@SafeVarargs
	public static <T> IEnumerable<T> of(T... source) {
		EnumerableList<T> list = new EnumerableList<T>(source.length);

		for (T value : source) {
			list.add(value);
		}

		return list;
	}

	public static <T> IEnumerable<T> of(Iterable<T> source) {
		return new IEnumerable<T>() {
			@Override
			public Iterator<T> iterator() {
				return source.iterator();
			}
		};
	}

	public static <T> IEnumerable<T> of(Stream<T> source) {
		return new IEnumerable<T>() {
			@Override
			public Iterator<T> iterator() {
				return source.iterator();
			}
		};
	}

	public static IIntegerEnumerable ofInteger(int[] source) {
		return new IIntegerEnumerable() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					private int current = -1;

					@Override
					public Integer next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static IIntegerEnumerable ofInteger(Integer... source) {
		return new IIntegerEnumerable() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					private int current = -1;

					@Override
					public Integer next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static IIntegerEnumerable ofInteger(Iterable<Integer> source) {
		return new IIntegerEnumerable() {
			@Override
			public Iterator<Integer> iterator() {
				return source.iterator();
			}
		};
	}

	public static ILongEnumerable ofLong(long[] source) {
		return new ILongEnumerable() {
			@Override
			public Iterator<Long> iterator() {
				return new Iterator<Long>() {
					private int current = -1;

					@Override
					public Long next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static ILongEnumerable ofLong(Long... source) {
		return new ILongEnumerable() {
			@Override
			public Iterator<Long> iterator() {
				return new Iterator<Long>() {
					private int current = -1;

					@Override
					public Long next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static ILongEnumerable ofLong(Iterable<Long> source) {
		return new ILongEnumerable() {
			@Override
			public Iterator<Long> iterator() {
				return source.iterator();
			}
		};
	}

	public static IDoubleEnumerable ofDouble(double[] source) {
		return new IDoubleEnumerable() {
			@Override
			public Iterator<Double> iterator() {
				return new Iterator<Double>() {
					private int current = -1;

					@Override
					public Double next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static IDoubleEnumerable ofDouble(Double... source) {
		return new IDoubleEnumerable() {
			@Override
			public Iterator<Double> iterator() {
				return new Iterator<Double>() {
					private int current = -1;

					@Override
					public Double next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static IDoubleEnumerable ofDouble(Iterable<Double> source) {
		return new IDoubleEnumerable() {
			@Override
			public Iterator<Double> iterator() {
				return source.iterator();
			}
		};
	}

	public static IEnumerable<Character> ofCharacter(char[] source) {
		return new IEnumerable<Character>() {
			@Override
			public Iterator<Character> iterator() {
				return new Iterator<Character>() {
					private int current = -1;

					@Override
					public Character next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static IEnumerable<Character> ofCharacter(String source) {
		return ofCharacter(source.toCharArray());
	}

	public static IEnumerable<Character> ofCharacter(Object source) {
		return ofCharacter(source.toString());
	}

	public static IEnumerable<Character> ofCharacter(Character... source) {
		return new IEnumerable<Character>() {
			@Override
			public Iterator<Character> iterator() {
				return new Iterator<Character>() {
					private int current = -1;

					@Override
					public Character next() {
						if (this.hasNext()) {
							this.current++;
							return source[this.current];
						} else {
							throw new NoSuchElementException();
						}
					}

					@Override
					public boolean hasNext() {
						return this.current + 1 < source.length;
					}
				};
			}
		};
	}

	public static <TMap extends Map<TKey, TValue>, TKey, TValue> IEnumerable<Entry<TKey, TValue>> ofMap(TMap map) {
		return new IEnumerable<Entry<TKey, TValue>>() {
			@Override
			public Iterator<Entry<TKey, TValue>> iterator() {
				return map.entrySet().iterator();
			}
		};
	}

	public static <T> IEnumerable<T> empty() {
		return new IEnumerable<T>() {
			@Override
			public Iterator<T> iterator() {
				return new Iterator<T>() {
					@Override
					public boolean hasNext() {
						return false;
					}

					@Override
					public T next() {
						throw new NoSuchElementException();
					}
				};
			}
		};
	}

	public static <T> IEnumerable<T> empty(Class<T> elementClass) {
		return Enumerable.<T> empty();
	}

	public static IEnumerable<Integer> forTo(int start, int finish) {
		return new IEnumerable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new AbstractEnumerator<Integer>() {
					private boolean first = true;

					private int current;

					@Override
					public Integer current() {
						return this.current;
					}

					@Override
					public boolean moveNext() {
						if (this.first) {
							this.current = start;
							this.first = false;
						} else {
							this.current++;
						}

						return this.current <= finish;
					}
				};
			}
		};
	}

	public static <T> IEnumerable<T> forTo(Func0<? extends T> first, Func1<? super T, Boolean> predicate, Func1<? super T, ? extends T> next) {
		return () -> IEnumerator.create(first, predicate, next);
	}

	public static IEnumerable<Integer> range(int start, int count) {
		return new IEnumerable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new LinqRangeEnumerator(start, count);
			}
		};
	}

	public static <T> IEnumerable<T> repeat(final T element, int count) {
		Func1<Integer, T> selector = new Func1<Integer, T>() {
			@Override
			public T func(Integer arg) {
				return element;
			}
		};

		return Enumerable.range(0, count).select(selector);
	}
}
