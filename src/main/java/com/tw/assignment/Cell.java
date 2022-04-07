package com.tw.assignment;

import com.tw.assignment.exception.NegativeCoordinateException;

import java.util.HashSet;
import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;

    public Cell(int xCoordinate, int yCoordinate) throws NegativeCoordinateException {
        if (xCoordinate < 0 || yCoordinate < 0) {
            throw new NegativeCoordinateException();
        }
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

    public HashSet<Cell> neighbours() throws NegativeCoordinateException {
        HashSet<Cell> neighbours = new HashSet<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;
                neighbours.add(new Cell(Math.abs(xCoordinate + x), Math.abs(yCoordinate + y)));
            }
        }
        return neighbours;
    }
}
