package com.github.jrh3k5.nest;

/*-
 * #%L
 * Nesting Exceptions
 * %%
 * Copyright (C) 2016 jrh3k5
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
    private final Mover descendent;

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
     *            The {@link Mover} descendent of this turtle.
     * @throws NullPointerException
     *             If the given descendent is {@code null}.
     */
    public Turtle(Mover descendent) {
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
