package com.tw.assignment;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {
    @Test
    void shouldAssertThatACellIsEqualToAnotherCellWhenTheCoordinatesAreEqual() {
        Cell cell = new Cell(7, 7);
        Cell anotherCell = new Cell(7, 7);

        assertEquals(cell, anotherCell);
    }

    @Test
    void shouldReturnTheCorrectNeighbourCellsForAnyCell() {
        Cell cell = new Cell(1, 1);
        HashSet<Cell> expectedNeighbourCells = new HashSet<>();
        expectedNeighbourCells.add(new Cell(0, 0));
        expectedNeighbourCells.add(new Cell(1, 0));
        expectedNeighbourCells.add(new Cell(2, 0));
        expectedNeighbourCells.add(new Cell(0, 1));
        expectedNeighbourCells.add(new Cell(2, 1));
        expectedNeighbourCells.add(new Cell(0, 2));
        expectedNeighbourCells.add(new Cell(1, 2));
        expectedNeighbourCells.add(new Cell(2, 2));

        HashSet<Cell> actualNeighbourCells = cell.neighbours();

        assertEquals(expectedNeighbourCells, actualNeighbourCells);
    }
}
