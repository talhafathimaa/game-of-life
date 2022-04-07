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
        for (Cell cell : currentAlive) {
            int aliveNeighbourCount = aliveNeighbourCount(cell);
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                nextGenerationAlive.add(cell);
            }
            for (Cell neighbour : cell.neighbours()) {
                if (!currentAlive.contains(neighbour) && aliveNeighbourCount(neighbour) == 3) {
                    nextGenerationAlive.add(neighbour);
                }
            }
        }
        currentAlive = nextGenerationAlive;
    }

    public HashSet<Cell> getNextGenerationAlive() {
        return currentAlive;
    }

    private int aliveNeighbourCount(Cell cell) throws NegativeCoordinateException {
        int aliveNeighbourCount = 0;
        for (Cell neighbour : cell.neighbours()) {
            if (currentAlive.contains(neighbour)) {
                aliveNeighbourCount++;
            }
        }
        return aliveNeighbourCount;
    }
}
