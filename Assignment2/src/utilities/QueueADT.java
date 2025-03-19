package utilities;

import java.util.NoSuchElementException;

/**
 * A generic interface representing a Queue Abstract Data Type (ADT).
 *
 * @param <T> The type of elements in the queue.
 */
public interface QueueADT<T> {
    
    /**
     * Initializes the queue with a specified size.
     *
     * @param size The maximum size of the queue.
     * @throws IllegalArgumentException if the size is non-positive.
     */
    void create(int size);

    /**
     * Adds an item to the back of the queue.
     *
     * @param item The item to be added.
     * @throws IllegalArgumentException if the item is null.
     * @throws IllegalStateException if the queue is full.
     */
    void enqueue(T item);

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return The item at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    T dequeue() throws NoSuchElementException;

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return The item at the front of the queue.
     * @throws NoSuchElementException if the queue is empty.
     */
    T front() throws NoSuchElementException;

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the queue.
     *
     * @return The current size of the queue.
     */
    int size();
}
