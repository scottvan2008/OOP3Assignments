package testDictionary;

import implementations.Dictionary;
import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryUnitTest {
    private Dictionary<String, Integer> dictionary;

    @BeforeEach
    void setUp() {
        dictionary = new Dictionary<>();
    }

    @Test
    void testInsert() throws DuplicateKeyException, KeyNotFoundException {
        dictionary.insert("A", 1);
        assertEquals(1, dictionary.size());
        assertEquals(1, dictionary.lookup("A"));
    }


    @Test
    void testInsertDuplicateKeyThrowsException() {
        assertThrows(DuplicateKeyException.class, () -> {
            dictionary.insert("A", 1);
            dictionary.insert("A", 2); // Should throw an exception
        });
    }

    @Test
    void testInsertNullKeyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dictionary.insert(null, 1));
    }

    @Test
    void testInsertNullValueThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dictionary.insert("A", null));
    }

    @Test
    void testRemove() throws DuplicateKeyException, KeyNotFoundException {
        dictionary.insert("A", 1);
        assertEquals(1, dictionary.remove("A"));
        assertEquals(0, dictionary.size());
    }

    @Test
    void testRemoveNonExistentKeyThrowsException() {
        assertThrows(KeyNotFoundException.class, () -> dictionary.remove("A"));
    }

    @Test
    void testRemoveNullKeyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dictionary.remove(null));
    }

    @Test
    void testUpdate() throws DuplicateKeyException, KeyNotFoundException {
        dictionary.insert("A", 1);
        dictionary.update("A", 2);
        assertEquals(2, dictionary.lookup("A"));
    }

    @Test
    void testUpdateNonExistentKeyThrowsException() {
        assertThrows(KeyNotFoundException.class, () -> dictionary.update("A", 2));
    }

    @Test
    void testUpdateNullKeyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dictionary.update(null, 2));
    }

    @Test
    void testUpdateNullValueThrowsException() throws DuplicateKeyException {
        dictionary.insert("A", 1);
        assertThrows(IllegalArgumentException.class, () -> dictionary.update("A", null));
    }

    @Test
    void testLookup() throws DuplicateKeyException, KeyNotFoundException {
        dictionary.insert("A", 1);
        assertEquals(1, dictionary.lookup("A"));
    }

    @Test
    void testLookupNonExistentKeyThrowsException() {
        assertThrows(KeyNotFoundException.class, () -> dictionary.lookup("A"));
    }

    @Test
    void testLookupNullKeyThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> dictionary.lookup(null));
    }

    @Test
    void testIsEmpty() {
        assertTrue(dictionary.isEmpty());
        assertDoesNotThrow(() -> dictionary.insert("A", 1));
        assertFalse(dictionary.isEmpty());
    }

    @Test
    void testSize() throws DuplicateKeyException {
        assertEquals(0, dictionary.size());
        dictionary.insert("A", 1);
        assertEquals(1, dictionary.size());
        dictionary.insert("B", 2);
        assertEquals(2, dictionary.size());
    }

    @Test
    void testClear() throws DuplicateKeyException {
        dictionary.insert("A", 1);
        dictionary.insert("B", 2);
        dictionary.clear();
        assertEquals(0, dictionary.size());
        assertTrue(dictionary.isEmpty());
    }
}
