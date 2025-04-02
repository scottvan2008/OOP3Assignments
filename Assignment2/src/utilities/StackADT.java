package utilities;

import java.util.EmptyStackException;

/**
 * A generic interface defining the behavior of a Stack Abstract Data Type (ADT).
 *
 * @param <T> The type of elements stored in the stack.
 */
public interface StackADT<T> {

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param item The element to be pushed.
     * @throws NullPointerException if the item is null.
     */
    void push(T item) throws NullPointerException;

    /**
     * Removes and returns the top element of the stack.
     *
     * @return The element removed from the top of the stack.
     * @throws EmptyStackException if the stack is empty.
     */
    T pop() throws EmptyStackException;

    /**
     * Returns the top element without removing it.
     *
     * @return The element at the top.
     * @throws EmptyStackException if the stack is empty.
     */
    T peek() throws EmptyStackException;

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty.
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the stack.
     *
     * @return The current size of the stack.
     */
    int size();

    /**
     * Removes all elements from the stack.
     */
    void clear();

    /**
     * Checks if the stack contains the specified element.
     *
     * @param item The element to search.
     * @return true if found, false otherwise.
     * @throws NullPointerException if item is null.
     */
    boolean contains(T item) throws NullPointerException;

    /**
     * Returns the 1-based position from the top of the stack.
     *
     * @param item The element to search.
     * @return 1-based position, or -1 if not found.
     * @throws NullPointerException if item is null.
     */
    int search(T item) throws NullPointerException;

    /**
     * Returns an array containing all elements from top to bottom.
     *
     * @return An array of elements.
     */
    Object[] toArray();

    /**
     * Returns an array containing all elements from top to bottom.
     *
     * @param holder Array to hold the elements.
     * @return An array of elements.
     * @throws NullPointerException if holder is null.
     */
    T[] toArray(T[] holder) throws NullPointerException;

    /**
     * Returns an iterator over the stack elements from top to bottom.
     *
     * @return An iterator.
     */
    Iterator<T> iterator();

    /**
     * Returns false since this stack has no fixed capacity.
     *
     * @return false
     */
    boolean stackOverflow();

    /**
     * Checks if this stack equals another stack.
     *
     * @param thatStack Another stack to compare.
     * @return true if equal.
     */
    boolean equals(Object thatStack);
}
