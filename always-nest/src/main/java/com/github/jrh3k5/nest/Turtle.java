package com.github.jrh3k5.nest;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Definition of a descendent of a mover.
 * 
 * @author Joshua Hyde
 */

public class Turtle implements Mover {
    private static final Logger LOGGER = LoggerFactory.getLogger(Turtle.class);
    private final Turtle descendent;

    /**
     * Create a turtle that is the prime mover.
     */
    public Turtle() {
        this.descendent = null;
    }

    /**
     * Create a turtle that has a descendent turtle.
     * 
     * @param descendent
     *            The {@link Turtle} descendent of this turtle.
     * @throws NullPointerException
     *             If the given descendent is {@code null}.
     */
    public Turtle(Turtle descendent) {
        this.descendent = Objects.requireNonNull(descendent, "Descendent cannot be null.");
    }

    @Override
    public void move(Universe universe) throws MoveException {
        // If this turtle is not the prime mover, delegate to the next mover
        if (descendent != null) {
            try {
                descendent.move(universe);
            } catch (MoveException e) {
                throw new MoveException(e.getMessage());
                // throw new MoveException(e.getMessage(), e);
            }
        } else {
            LOGGER.info("Universe {} has been moved.", universe);
        }
    }
}
