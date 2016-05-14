package com.github.visgeek.utils.collections.test.testcase.enumerable.of;

import java.util.ArrayList;

import com.github.visgeek.utils.Action1;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.collections.IEnumerable;
import com.github.visgeek.utils.testing.CollectionCreator;

@SuppressWarnings("unchecked")
class TestPatternCollection<T, TPrimitiveArray, TEnumerable> {
	// コンストラクター
	TestPatternCollection(
							T[] objectsEmpty,
							T[] objectsFilled,
							TPrimitiveArray primitivesEmpty,
							TPrimitiveArray primitivesFilled,
							Func1<TPrimitiveArray, TEnumerable> ofForPrimitiveArray,
							Func1<T[], TEnumerable> ofForObjectArray,
							Func1<Iterable<T>, TEnumerable> ofForIterable,
							Action1<TEnumerable> action) {

		this.objectsEmpty = objectsEmpty;
		this.primitivesEmpty = primitivesEmpty;

		this.ofForPrimitiveArray = ofForPrimitiveArray;
		this.ofForObjectArray = ofForObjectArray;
		this.ofForIterable = ofForIterable;
		this.action = action;

		if (primitivesEmpty != null) {
			this.add("%1$s[] empty              ", this.ofForPrimitiveArray, primitivesEmpty);
			this.add("%1$s[] filled             ", this.ofForPrimitiveArray, primitivesFilled);
		}

		this.add("IEnumerable<%2$s> empty   ", this.ofForIterable, (IEnumerable<T>) () -> CollectionCreator.iterator());
		this.add("IEnumerable<%2$s> filled  ", this.ofForIterable, (IEnumerable<T>) () -> CollectionCreator.iterator(objectsFilled));
		this.add("%2$s[] empty              ", this.ofForObjectArray, objectsEmpty);
		this.add("%2$s[] filled             ", this.ofForObjectArray, objectsFilled);
		this.add("ArrayList<%2$s> empty     ", this.ofForIterable, CollectionCreator.arrayList(objectsEmpty));
		this.add("ArrayList<%2$s> filled    ", this.ofForIterable, CollectionCreator.arrayList(objectsFilled));
		this.add("LinkedList<%2$s> empty    ", this.ofForIterable, CollectionCreator.linkedList(objectsEmpty));
		this.add("LinkedList<%2$s> filled   ", this.ofForIterable, CollectionCreator.linkedList(objectsFilled));
		this.add("Collection<%2$s> empty    ", this.ofForIterable, CollectionCreator.collection(objectsEmpty));
		this.add("Collection<%2$s> filled   ", this.ofForIterable, CollectionCreator.collection(objectsFilled));
		this.add("Iterable<%2$s> empty      ", this.ofForIterable, CollectionCreator.iterable(objectsEmpty));
		this.add("Iterable<%2$s> filled     ", this.ofForIterable, CollectionCreator.iterable(objectsFilled));
	}

	// フィールド
	private final T[] objectsEmpty;

	private final TPrimitiveArray primitivesEmpty;

	private final Func1<TPrimitiveArray, TEnumerable> ofForPrimitiveArray;

	private final Func1<T[], TEnumerable> ofForObjectArray;

	private final Func1<Iterable<T>, TEnumerable> ofForIterable;

	private final Action1<TEnumerable> action;

	private final ArrayList<TestPattern<?>> items = new ArrayList<>();

	// メソッド
	private final <TArg> void add(String name, Func1<TArg, TEnumerable> method, TArg arg) {
		TestPattern<TArg> ins = new TestPattern<>(name, method, arg);
		this.items.add(ins);
	}

	public void run() {
		for (TestPattern<?> pattern : this.items) {
			pattern.run();
		}
	}

	// クラス
	private class TestPattern<TArg> {
		public TestPattern(String name, Func1<TArg, TEnumerable> method, TArg arg) {
			this._name = name.trim();
			this.method = method;
			this.source = arg;
		}

		private final String _name;

		private final TArg source;

		private final Func1<TArg, TEnumerable> method;

		private String name() {
			String pName = TestPatternCollection.this.primitivesEmpty == null ? "" : TestPatternCollection.this.primitivesEmpty.getClass().getComponentType().getSimpleName();
			String oName = TestPatternCollection.this.objectsEmpty == null ? "" : TestPatternCollection.this.objectsEmpty.getClass().getComponentType().getSimpleName();

			return String.format(this._name, pName, oName);
		}

		public void run() {
			try {
				TEnumerable source = this.method.func(this.source);
				TestPatternCollection.this.action.action(source);
			} catch (Exception e) {
				throw new RuntimeException(this.name(), e);
			}
		}
	}
}
