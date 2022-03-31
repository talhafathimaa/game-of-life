package com.tw.assignment;

import java.util.HashSet;

public class Universe {
    private final HashSet<Cell> alive;
    private HashSet<Cell> nextGenerationAlive;

    public Universe(HashSet<Cell> alive) {
        this.alive = alive;
        this.nextGenerationAlive = new HashSet<>();
    }

    public void tick() {
        for (Cell cell : alive) {
            int aliveNeighbourCount = aliveNeighbourCount(cell);
            if (aliveNeighbourCount == 2 || aliveNeighbourCount == 3) {
                nextGenerationAlive.add(cell);
            }
            for (Cell neighbour : cell.neighbours()) {
                if (!alive.contains(neighbour)) {
                    if (aliveNeighbourCount(neighbour) == 3) {
                        nextGenerationAlive.add(neighbour);
                    }
                }
            }
        }
    }

    public HashSet<Cell> getNextGenerationAlive() {
        return nextGenerationAlive;
    }

    private int aliveNeighbourCount(Cell cell) {
        int aliveNeighbourCount = 0;
        for (Cell neighbour : cell.neighbours()) {
            if (alive.contains(neighbour)) {
                aliveNeighbourCount++;
            }
        }
        return aliveNeighbourCount;
    }
}
