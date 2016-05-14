package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;

public interface IMap<K, V> extends java.util.Map<K, V>, IReadOnlyMap<K, V> {
	/**
	 * containsKey(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	default boolean containsKey2(K key) {
		return this.containsKey(key);
	}

	/**
	 * containsValue(Object value) と同じ動作です。
	 * @param value
	 * @return
	 */
	default boolean containsValue2(V value) {
		return this.containsValue(value);
	}

	/**
	 * get(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	default V getValue(K key) {
		return this.get(key);
	}

	@Override
	default V getValueOrDefault(K key, V defaultValue) {
		return this.getOrDefault(key, defaultValue);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V getValueOrPut(K key, V defaultValue) {
		return this.getValueOrPut(key, () -> defaultValue, null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @param lockObject
	 * @return
	 */
	default V getValueOrPut(K key, V defaultValue, Object lockObject) {
		return this.getValueOrPut(key, () -> defaultValue, lockObject);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V getValueOrPut(K key, Func0<? extends V> defaultValue) {
		return this.getValueOrPut(key, defaultValue, null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。ロック用オブジェクトを指定すると同期的登録処理となります。
	 * @param key
	 * @param defaultValue
	 * @param lockObject 同期処理のためのロック用オブジェクト。または null。
	 * @return
	 */
	default V getValueOrPut(K key, Func0<? extends V> defaultValue, Object lockObject) {
		Errors.throwIfNull(defaultValue, "defaultValue");

		V result;

		if (this.containsKey2(key)) {
			result = this.getValue(key);

		} else if (lockObject == null) {
			result = defaultValue.func();
			this.put(key, result);

		} else {
			synchronized (lockObject) {
				if (this.containsKey2(key)) {
					result = this.getValue(key);

				} else {
					result = defaultValue.func();
					this.put(key, result);
				}
			}
		}

		return result;
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V getValueOrPut(K key, Func1<? super K, ? extends V> defaultValue) {
		return this.getValueOrPut(key, defaultValue.partialApply(key), null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。ロック用オブジェクトを指定すると同期的登録処理となります。
	 * @param key
	 * @param defaultValue
	 * @param lockObject 同期処理のためのロック用オブジェクト。または null。
	 * @return
	 */
	default V getValueOrPut(K key, Func1<? super K, ? extends V> defaultValue, Object lockObject) {
		return this.getValueOrPut(key, defaultValue.partialApply(key), lockObject);
	}

	@Override
	boolean isEmpty();

	@Override
	default Iterator<Entry<K, V>> iterator() {
		return this.entrySet().iterator();
	}

	/**
	 * 指定したシーケンスの要素を指定したセレクター関数取得したキーに関連付けて登録します。
	 * @param values
	 * @param keySelector
	 */
	default void putAll(Iterable<? extends V> values, Func1<? super V, ? extends K> keySelector) {
		Errors.throwIfNull(values, "values");
		Errors.throwIfNull(keySelector, "keySelector");

		for (V value : values) {
			K key = keySelector.func(value);
			this.put(key, value);
		}
	}

	/**
	 * 指定したセレクター関数で指定したシーケンスの要素から取得したキーと値を登録します。
	 * @param source
	 * @param keySelector
	 * @param valueSelector
	 */
	default <TSource> void putAll(Iterable<? extends TSource> source, Func1<? super TSource, ? extends K> keySelector, Func1<? super TSource, ? extends V> valueSelector) {
		Errors.throwIfNull(source, "source");
		Errors.throwIfNull(keySelector, "keySelector");
		Errors.throwIfNull(valueSelector, "valueSelector");

		for (TSource item : source) {
			K key = keySelector.func(item);
			V val = valueSelector.func(item);
			this.put(key, val);
		}
	}

	/**
	 * キーに関連する値が登録されていない場合に値を登録します。
	 * @param key
	 * @param value
	 * @return
	 */
	default V putIfAbsent(K key, Func0<? extends V> value) {
		Errors.throwIfNull(value, "value");

		V result = this.getValue(key);

		if (result == null) {
			result = this.put(key, value.func());
		}

		return result;
	}

	/**
	 * キーに関連する値が登録されていない場合に値を登録します。
	 * @param key
	 * @param value
	 * @return
	 */
	default V putIfAbsent(K key, Func1<? super K, ? extends V> value) {
		Errors.throwIfNull(value, "value");

		V result = this.getValue(key);

		if (result == null) {
			result = this.put(key, value.func(key));
		}

		return result;
	}

	/**
	 * 指定されたキーと値を登録します。
	 * @param key
	 * @param value
	 * @return
	 */
	default V putOrThrow(K key, V value) {
		if (this.containsKey2(key)) {
			throw new IllegalArgumentException(String.format("key %s already exists.", key));
		} else {
			return this.put(key, value);
		}
	}

	/**
	 * remove(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	default V removeValue(K key) {
		return this.remove(key);
	}

	/**
	 * 指定したキーと関連付けられた値を削除し、その値を取得します。キーが登録されていない場合は指定した関数の結果を取得します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V removeValueOrDefault(K key, Func0<? extends V> defaultValue) {
		Errors.throwIfNull(defaultValue, "defaultValue");

		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			return defaultValue.func();
		}
	}

	/**
	 * 指定したキーと関連付けられた値を削除し、その値を取得します。キーが登録されていない場合は指定した関数の結果を取得します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V removeValueOrDefault(K key, Func1<? super K, ? extends V> defaultValue) {
		Errors.throwIfNull(defaultValue, "defaultValue");
		return this.removeValueOrDefault(key, defaultValue.partialApply(key));
	}

	/**
	 * 指定したキーと関連付けられた値を削除し、その値を取得します。キーが登録されていない場合は指定した規定値を取得します。
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	default V removeValueOrDefault(K key, V defaultValue) {
		return this.removeValueOrDefault(key, () -> defaultValue);
	}

	/**
	 * 指定したキーと関連付けられた値を削除し、その値を取得します。キーが登録されていない場合は例外が発生します。
	 * @param key
	 * @return
	 */
	default V removeValueOrThrow(K key) {
		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			throw new IllegalArgumentException(String.format("key '%s' is not found.", key));
		}
	}
}
