package com.github.visgeek.utils.collections;

import java.util.Iterator;

import com.github.visgeek.utils.Func0;
import com.github.visgeek.utils.Func1;
import com.github.visgeek.utils.Func2;

public interface IMap<K, V> extends java.util.Map<K, V>, IReadOnlyMap<K, V> {
	default boolean containsKey2(K key) {
		return this.containsKey(key);
	}

	default boolean containsValue2(V value) {
		return this.containsValue(value);
	}

	@Override
	default int count() {
		return this.size();
	}

	/**
	 * get(Object key) と同じ動作です。
	 * @param key
	 * @return
	 */
	default V getValue(K key) {
		return this.get(key);
	}

	/**
	 * getOrDefault(Object Key, V defaultValue) と同じ動作です。
	 */
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
	default V getValueOrPut(K key, Func1<K, ? extends V> defaultValue) {
		return this.getValueOrPut(key, defaultValue, null);
	}

	/**
	 * キーに関連する値を取得します。登録されていない場合は規定値を登録します。ロック用オブジェクトを指定すると同期的登録処理となります。
	 * @param key
	 * @param defaultValue
	 * @param lockObject 同期処理のためのロック用オブジェクト。または null。
	 * @return
	 */
	default V getValueOrPut(K key, Func1<K, ? extends V> defaultValue, Object lockObject) {
		return this.getValueOrPut(key, () -> defaultValue.func(key), lockObject);
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
		V result;

		result = this.getValue(key);
		if (result == null) {
			if (lockObject == null) {
				result = defaultValue.func();
				this.put(key, result);
			} else {
				synchronized (lockObject) {
					result = this.getValue(key);
					if (result == null) {
						result = defaultValue.func();
						this.put(key, result);
					}
				}
			}
		}

		return result;
	}

	@Override
	default IEnumerable<K> enumerateKeys() {
		return Enumerable.of(this.keySet());
	}

	@Override
	default IEnumerable<V> enumerateValues() {
		return Enumerable.of(this.values());
	}

	default V putOrThrow(K key, V value) {
		return this.putOrThrow(key, value, (k, v) -> String.format("key %s already exists.", key));
	}

	default V putOrThrow(K key, V value, String errorMessage) {
		return this.putOrThrow(key, value, (k, v) -> errorMessage);
	}

	default V putOrThrow(K key, V value, Func2<K, V, String> errorMessage) {
		if (this.containsKey2(key)) {
			throw new IllegalArgumentException(errorMessage.func(key, value));
		} else {
			return this.put(key, value);
		}
	}

	/**
	 * キーに関連する値が登録されていない場合に値を登録します。
	 * @param key
	 * @param value
	 * @return
	 */
	default V putIfAbsent(K key, Func0<? extends V> value) {
		V result = null;

		if (!this.containsKey2(key)) {
			result = this.putIfAbsent(key, value.func());
		}

		return result;
	}

	default void putAll(IEnumerable<? extends V> values, Func1<? super V, ? extends K> keySelector) {
		for (V value : values) {
			K key = keySelector.func(value);
			this.put(key, value);
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

	default V removeValueOrThrow(K key) {
		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			throw new IllegalArgumentException(String.format("key '%s' is not found.", key));
		}
	}

	default V removeValueOrDefault(K key, V defaultValue) {
		return this.removeValueOrDefault(key, () -> defaultValue);
	}

	default V removeValueOrDefault(K key, Func0<? extends V> defaultValue) {
		if (this.containsKey2(key)) {
			return this.removeValue(key);
		} else {
			return defaultValue.func();
		}
	}

	@Override
	default Iterator<Entry<K, V>> iterator() {
		return this.entrySet().iterator();
	}
}
