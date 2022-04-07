package com.tw.assignment;

import com.tw.assignment.exception.NegativeCoordinateException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellTest {
    @Test
    void shouldAssertThatACellIsEqualToAnotherCellWhenTheCoordinatesAreEqual() throws NegativeCoordinateException {
        Cell cell = new Cell(7, 7);
        Cell anotherCell = new Cell(7, 7);

        assertEquals(cell, anotherCell);
    }

    @Test
    void shouldNotCreateCellIfCoordinateIsNegative() {
        assertThrows(NegativeCoordinateException.class, () -> new Cell(-1, 1));
    }
}
