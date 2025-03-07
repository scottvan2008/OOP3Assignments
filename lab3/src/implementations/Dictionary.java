package implementations;

import java.util.ArrayList;
import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;
import utilities.DictionaryADT;

public class Dictionary<K, V> implements DictionaryADT<K, V> {

	private ArrayList<K> keys;
	private ArrayList<V> values;

	public Dictionary() {
		keys = new ArrayList<>();
		values = new ArrayList<>();
	}

	@Override
	public void insert(K key, V value) throws DuplicateKeyException {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key and value cannot be null");
		}
		if (keys.contains(key)) {
			throw new DuplicateKeyException("Key already exists: " + key);
		}
		keys.add(key);
		values.add(value);
	}

	@Override
	public V remove(K key) throws KeyNotFoundException {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotFoundException("Key not found: " + key);
		}
		keys.remove(index);
		return values.remove(index);
	}

	@Override
	public void update(K key, V value) throws KeyNotFoundException {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key and value cannot be null");
		}
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotFoundException("Key not found: " + key);
		}
		values.set(index, value);
	}

	@Override
	public V lookup(K key) throws KeyNotFoundException {
		if (key == null) {
			throw new IllegalArgumentException("Key cannot be null");
		}
		int index = keys.indexOf(key);
		if (index == -1) {
			throw new KeyNotFoundException("Key not found: " + key);
		}
		return values.get(index);
	}

	@Override
	public boolean isEmpty() {
		return keys.isEmpty();
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public void clear() {
		keys.clear();
		values.clear();
	}
}

