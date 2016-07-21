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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for the universe.
 * 
 * @author Joshua Hyde
 */

public class UniverseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UniverseTest.class);

    /**
     * Test what happens when you don't nest your exceptions as causes.
     * 
     * @throws Exception
     */
    @Test
    public void testNonNestedException() throws Exception {
        final Universe universe = new Universe();

        // Randomly determine which turtle throws an exception
        final int errorTurtle = RandomUtils.nextInt(0, 9);

        // Build a hierarchy of turtles
        final List<Turtle> turtles = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            final Turtle turtle;
            if (i == errorTurtle) {
                turtle = mock(Turtle.class);
                doThrow(new MoveException("Kaboom!")).when(turtle).move(universe);
            } else {
                turtle = i == 0 ? new Turtle() : new Turtle(turtles.get(i - 1));
            }
            turtles.add(turtle);
        }

        MoveException caught = null;
        try {
        turtles.get(turtles.size() - 1).move(universe);
        } catch (MoveException e) {
            caught = e;
        }

        assertThat(caught).isNotNull();
        LOGGER.info("An expected exception was caught during the test.", caught);
    }

}
