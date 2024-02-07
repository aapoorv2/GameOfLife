package org.example;

import java.util.List;

public class Cell {
    private State state;

    Cell(State state) {
        this.state = state;
    }
    boolean isAlive() {
        return state == State.ALIVE;
    }

    Cell evolve(List<Cell> neighbours) {
        int aliveCount = countAliveNeighbours(neighbours);
        if (isAlive() && (aliveCount < 2 || aliveCount > 3)) {
            return new Cell(State.DEAD);
        } else if (!isAlive() && aliveCount == 3) {
            return new Cell(State.ALIVE);
        }
        return this;
    }
    int countAliveNeighbours(List<Cell> neighbours) {
        int countAlive = 0;
        for (Cell cell : neighbours) {
            if(cell.isAlive()) {
                countAlive++;
            }
        }
        return countAlive;
    }
}
