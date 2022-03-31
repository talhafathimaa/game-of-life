package com.tw.assignment;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniverseTest {
    @Test
    void ShouldBeAbleToGetAliveCellsOfNextGenerationForBlockPattern() {
        HashSet<Cell> alive = new HashSet<>();
        alive.add(new Cell(1, 1));
        alive.add(new Cell(1, 2));
        alive.add(new Cell(2, 1));
        alive.add(new Cell(2, 2));
        HashSet<Cell> expectedNextGenerationAlive = new HashSet<>();
        expectedNextGenerationAlive.add(new Cell(1, 1));
        expectedNextGenerationAlive.add(new Cell(1, 2));
        expectedNextGenerationAlive.add(new Cell(2, 1));
        expectedNextGenerationAlive.add(new Cell(2, 2));
        Universe universe = new Universe(alive);

        universe.tick();
        HashSet<Cell> actualNextGenerationAlive = universe.getNextGenerationAlive();

        assertEquals(expectedNextGenerationAlive, actualNextGenerationAlive);
    }

    @Test
    void ShouldBeAbleToGetAliveCellsOfNextGenerationForBoatPattern() {
        HashSet<Cell> alive = new HashSet<>();
        alive.add(new Cell(0, 1));
        alive.add(new Cell(1, 0));
        alive.add(new Cell(2, 1));
        alive.add(new Cell(0, 2));
        alive.add(new Cell(1, 2));
        HashSet<Cell> expectedNextGenerationAlive = new HashSet<>();
        expectedNextGenerationAlive.add(new Cell(0, 1));
        expectedNextGenerationAlive.add(new Cell(1, 0));
        expectedNextGenerationAlive.add(new Cell(2, 1));
        expectedNextGenerationAlive.add(new Cell(0, 2));
        expectedNextGenerationAlive.add(new Cell(1, 2));
        Universe universe = new Universe(alive);

        universe.tick();
        HashSet<Cell> actualNextGenerationAlive = universe.getNextGenerationAlive();

        assertEquals(expectedNextGenerationAlive, actualNextGenerationAlive);
    }
}
