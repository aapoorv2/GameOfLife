package org.example;

import java.util.List;

public class Cell {
    private State state;
    private State nextState;
    Cell(State state) {
        this.state = state;
        this.nextState = state;
    }
    boolean isAlive() {
        return state == State.ALIVE;
    }

    void evolve(List<Cell> neighbours) {
        int aliveCount = countAliveNeighbours(neighbours);
        if (isAlive() && (aliveCount < 2 || aliveCount > 3)) {
            this.nextState = State.DEAD;
        } else if (!isAlive() && aliveCount == 3) {
            this.nextState = State.ALIVE;
        }
    }
    void update() {
        this.state = this.nextState;
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
