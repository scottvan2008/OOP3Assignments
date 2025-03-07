package utilities;

/**
* DictionaryADT.java
*
* @author your name
* @version major.minor revision number starting at 1.0
*
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab.
*/


import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;

/**
 * DictionaryADT.java
 *
 * @param <K> the type of keys in this dictionary
 * @param <V> the type of values associated with the keys
 *
 * This interface represents the public contract for the implementation of Dictionary.
 */
public interface DictionaryADT<K, V> {

    /**
     * Inserts a (key, value) pair into the dictionary.
     * @param key the key to insert
     * @param value the value associated with the key
     * @throws DuplicateKeyException if the key already exists
     * @throws IllegalArgumentException if key or value is null
     */
    void insert(K key, V value) throws DuplicateKeyException;

    /**
     * Removes a key and its associated value from the dictionary.
     * @param key the key to remove
     * @return the value that was removed
     * @throws KeyNotFoundException if the key does not exist
     * @throws IllegalArgumentException if key is null
     */
    V remove(K key) throws KeyNotFoundException;

    /**
     * Updates the value associated with a key.
     * @param key the key to update
     * @param value the new value
     * @throws KeyNotFoundException if the key does not exist
     * @throws IllegalArgumentException if key or value is null
     */
    void update(K key, V value) throws KeyNotFoundException;

    /**
     * Looks up the value associated with a given key.
     * @param key the key to look up
     * @return the associated value
     * @throws KeyNotFoundException if the key does not exist
     * @throws IllegalArgumentException if key is null
     */
    V lookup(K key) throws KeyNotFoundException;

    /**
     * Checks if the dictionary is empty.
     * @return true if the dictionary is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of key-value pairs in the dictionary.
     * @return the size of the dictionary
     */
    int size();

    /**
     * Clears all key-value pairs in the dictionary.
     */
    void clear();
}