package com.github.jrh3k5.nest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Definition of a universe.
 * 
 * @author Joshua Hyde
 */

public class Universe {
    private static final Logger LOGGER = LoggerFactory.getLogger(Universe.class);
    /**
     * Set this universe in action.
     */
    public void move() {
        LOGGER.info("Gentlemen! Start your engines!");
    }
}
