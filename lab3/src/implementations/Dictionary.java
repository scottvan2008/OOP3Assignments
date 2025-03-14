package implementations;

import java.util.ArrayList;
import exceptions.DuplicateKeyException;
import utilities.DictionaryADT;

public class Dictionary<K, V> implements DictionaryADT<K, V> {
	private ArrayList<K> keys;
	private ArrayList<V> values;
	private int maxSize;

	// Default constructor, initializes with a default size of 10
	public Dictionary() {
		this(10);
	}

	// Constructor that allows specifying the dictionary size
	public Dictionary(int size) {
		create(size);
	}

	@Override
	public void create(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be greater than 0.");
		}
		this.maxSize = size;
		this.keys = new ArrayList<>(size);
		this.values = new ArrayList<>(size);
	}

	@Override
	public boolean insert(K key, V value) throws DuplicateKeyException {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key and value cannot be null.");
		}
		if (keys.contains(key)) {
			throw new DuplicateKeyException("Key already exists: " + key);
		}
		if (keys.size() >= maxSize) {
			throw new IllegalStateException("Dictionary has reached its maximum size.");
		}
		keys.add(key);
		values.add(value);
		return true;
	}

	@Override
	public V remove(K key) {
		int index = keys.indexOf(key);
		if (index == -1) {
			return null; // Return null if the key does not exist
		}
		keys.remove(index);
		return values.remove(index);
	}

	@Override
	public boolean update(K key, V value) {
		int index = keys.indexOf(key);
		if (index == -1) {
			return false; // Return false if the key does not exist
		}
		values.set(index, value);
		return true;
	}

	@Override
	public V lookup(K key) {
		int index = keys.indexOf(key);
		if (index == -1) {
			return null; // Return null if the key does not exist
		}
		return values.get(index);
	}
}
