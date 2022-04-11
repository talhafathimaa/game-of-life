package com.tw.assignment;

import com.tw.assignment.exception.NegativeCoordinateException;

import java.util.HashSet;

public class Universe {
    private HashSet<Cell> currentAlive;

    public Universe(HashSet<Cell> alive) {
        this.currentAlive = alive;
    }

    public void tick() throws NegativeCoordinateException {
        HashSet<Cell> nextGenerationAlive = new HashSet<>();
        HashSet<Cell> nextGenerationDead = new HashSet<>();
        for (Cell cell : currentAlive) {
            int aliveNeighbourCount = aliveNeighbourCount(cell);
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                nextGenerationAlive.add(cell);
            } else {
                nextGenerationDead.add(cell);
            }
            for (Cell neighbour : neighbours(cell)) {
                if (!currentAlive.contains(neighbour) && aliveNeighbourCount(neighbour) == 3) {
                    nextGenerationAlive.add(neighbour);
                }
            }
        }
        updateState(nextGenerationDead, State.DEAD);
        updateState(nextGenerationAlive, State.ALIVE);
        currentAlive = nextGenerationAlive;
    }

    private void updateState(HashSet<Cell> cells, State state) {
        for (Cell cell : cells) {
            cell.setState(state);
        }
    }

    public HashSet<Cell> getNextGenerationAlive() {
        return currentAlive;
    }

    private int aliveNeighbourCount(Cell cell) throws NegativeCoordinateException {
        int aliveNeighbourCount = 0;
        for (Cell neighbour : neighbours(cell)) {
            if (currentAlive.contains(neighbour)) {
                aliveNeighbourCount++;
            }
        }
        return aliveNeighbourCount;
    }

    private HashSet<Cell> neighbours(Cell cell) throws NegativeCoordinateException {
        HashSet<Cell> neighbours = new HashSet<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0)
                    continue;
                Cell neighbourCell = new Cell(Math.abs(cell.getXCoordinate() + x), Math.abs(cell.getYCoordinate() + y));
                if (!currentAlive.contains(neighbourCell)) {
                    neighbourCell.setState(State.DEAD);
                }
                neighbours.add(neighbourCell);
            }
        }
        return neighbours;
    }
}
