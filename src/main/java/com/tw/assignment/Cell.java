package com.tw.assignment;

import java.util.HashSet;
import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private HashSet<Cell> neighbours;

    public Cell(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.neighbours = new HashSet<>();
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

    public HashSet<Cell> neighbours() {
        neighbours.add(new Cell(xCoordinate - 1, yCoordinate));
        neighbours.add(new Cell(xCoordinate - 1, yCoordinate - 1));
        neighbours.add(new Cell(xCoordinate - 1, yCoordinate + 1));
        neighbours.add(new Cell(xCoordinate, yCoordinate + 1));
        neighbours.add(new Cell(xCoordinate, yCoordinate - 1));
        neighbours.add(new Cell(xCoordinate + 1, yCoordinate));
        neighbours.add(new Cell(xCoordinate + 1, yCoordinate - 1));
        neighbours.add(new Cell(xCoordinate + 1, yCoordinate + 1));
        return neighbours;
    }
}
