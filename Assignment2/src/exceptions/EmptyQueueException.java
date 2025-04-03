package exceptions;

import java.util.NoSuchElementException;

/**
 * Exception thrown when attempting to dequeue from an empty queue.
 */
public class EmptyQueueException extends NoSuchElementException {

    /**
     * Constructs an EmptyQueueException with no detail message.
     */
    public EmptyQueueException() {
        super("Queue is empty.");
    }

    /**
     * Constructs an EmptyQueueException with the specified detail message.
     *
     * @param message The detail message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}

