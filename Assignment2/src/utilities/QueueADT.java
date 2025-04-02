package utilities;

import exceptions.EmptyQueueException;

/**
 * A generic interface defining the behavior of a Queue Abstract Data Type (ADT).
 *
 * @param <T> The type of elements stored in the queue.
 */
public interface QueueADT<T> {

    /**
     * Adds an element to the end of the queue.
     *
     * @param item The element to add.
     * @throws NullPointerException if item is null.
     */
    void enqueue(T item) throws NullPointerException;

    /**
     * Removes and returns the front element.
     *
     * @return The element removed.
     * @throws EmptyQueueException if queue is empty.
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the front element without removing.
     *
     * @return The front element.
     * @throws EmptyQueueException if queue is empty.
     */
    T peek() throws EmptyQueueException;

    /**
     * Checks if the queue is empty.
     *
     * @return true if empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements.
     *
     * @return The size.
     */
    int size();

    /**
     * Removes all elements.
     */
    void clear();

    /**
     * Removes all elements.
     */
    void dequeueAll();

    /**
     * Checks if queue contains specified element.
     *
     * @param item The element to search.
     * @return true if found.
     * @throws NullPointerException if item is null.
     */
    boolean contains(T item) throws NullPointerException;

    /**
     * Returns index (1-based) of item, or -1.
     *
     * @param item The element to search.
     * @return 1-based index or -1.
     */
    int search(T item);

    /**
     * Returns an array of queue elements.
     *
     * @return An array.
     */
    Object[] toArray();

    /**
     * Returns an array of queue elements.
     *
     * @param holder Array to hold elements.
     * @return An array.
     * @throws NullPointerException if holder is null.
     */
    T[] toArray(T[] holder) throws NullPointerException;

    /**
     * Returns an iterator over queue elements.
     *
     * @return An iterator.
     */
    Iterator<T> iterator();

    /**
     * Returns false since queue has no fixed capacity.
     *
     * @return false
     */
    boolean isFull();

    /**
     * Checks if this queue equals another queue.
     *
     * @param thatQueue The queue to compare.
     * @return true if equal.
     */
    boolean equals(Object thatQueue);
}
