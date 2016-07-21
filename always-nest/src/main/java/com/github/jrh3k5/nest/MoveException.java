package com.github.jrh3k5.nest;

/**
 * An exception indicating an error occurred while trying to move a universe.
 * 
 * @author Joshua Hyde
 */

public class MoveException extends Exception {
    private static final long serialVersionUID = -5881747065902648663L;

    /**
     * Create an exception.
     * 
     * @param message
     *            The message associated with the exception.
     */
    public MoveException(String message) {
        super(message);
    }

    /**
     * Create an exception.
     * 
     * @param message
     *            The message associated with the exception.
     * @param cause
     *            The {@link Throwable} cause of the exception.
     */
    public MoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
