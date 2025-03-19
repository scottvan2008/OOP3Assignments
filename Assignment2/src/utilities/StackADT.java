package utilities;

/**
 * A generic interface representing a Stack Abstract Data Type (ADT).
 *
 * @param <T> The type of elements in the stack.
 */
public interface StackADT<T> {
    
    /**
     * Initializes the stack with a specified size.
     *
     * @param size The maximum size of the stack.
     * @throws IllegalArgumentException if the size is non-positive.
     */
    void create(int size);

    /**
     * Pushes an item onto the stack.
     *
     * @param item The item to be pushed onto the stack.
     * @throws IllegalArgumentException if the item is null.
     * @throws IllegalStateException if the stack is full.
     */
    void push(T item);

    /**
     * Removes and returns the top item of the stack.
     *
     * @return The item removed from the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    T pop();

    /**
     * Returns the top item of the stack without removing it.
     *
     * @return The top item of the stack.
     * @throws NoSuchElementException if the stack is empty.
     */
    T peek();

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the number of items currently in the stack.
     *
     * @return The current size of the stack.
     */
    int size();
}