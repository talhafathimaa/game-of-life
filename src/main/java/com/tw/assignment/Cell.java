package com.tw.assignment;

import com.tw.assignment.exception.NegativeCoordinateException;

import java.util.Objects;

public class Cell {
    private final int xCoordinate;
    private final int yCoordinate;
    private State state;

    public Cell(int xCoordinate, int yCoordinate) throws NegativeCoordinateException {
        if (xCoordinate < 0 || yCoordinate < 0) {
            throw new NegativeCoordinateException();
        }
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.state = State.ALIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        if (this == o) return true;
        Cell obj = (Cell) o;
        return (this.xCoordinate == obj.xCoordinate && this.yCoordinate == obj.yCoordinate && this.state == obj.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, state);
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setState(State state) {
        this.state = state;
    }
}
