package com.github.jrh3k5.nest;

/**
 * Definition of an entity that can move a universe.
 * 
 * @author Joshua Hyde
 */

public interface Mover {
    /**
     * Moves a universe.
     * 
     * @param universe
     *            The {@link Universe} to be moved.
     * @throws MoveException
     *             If any errors occur during the test run.
     */
    void move(Universe universe) throws MoveException;
}
