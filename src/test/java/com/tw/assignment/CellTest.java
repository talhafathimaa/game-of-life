package com.tw.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {
    @Test
    void shouldAssertThatACellIsEqualToAnotherCellWhenTheCoordinatesAreEqual() {
        Cell cell = new Cell(7, 7);
        Cell anotherCell=new Cell(7,7);

        assertEquals(cell,anotherCell);
    }
}
