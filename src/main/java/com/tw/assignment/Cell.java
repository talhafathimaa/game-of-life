package com.tw.assignment;

import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        Cell obj = (Cell) o;
        return (this.xCoordinate == obj.xCoordinate && this.yCoordinate == obj.yCoordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
