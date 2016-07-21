package com.github.jrh3k5.nest;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * Tests for the universe.
 * 
 * @author Joshua Hyde
 */

public class UniverseTest {
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

        turtles.get(turtles.size() - 1).move(universe);
    }

}
