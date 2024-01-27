package org.example;

import java.util.List;

public class Cell {
    private State state;
    private State newState;
    Cell(State state) {
        this.state = state;
        this.newState = state;
    }
    boolean isAlive() {
        return state == State.ALIVE;
    }

    void applyRules(List<Cell> neighbours) {
        int aliveCount = countAliveNeighbours(neighbours);
        if (isAlive() && (aliveCount < 2 || aliveCount > 3)) {
            this.newState = State.DEAD;
        } else if (!isAlive() && aliveCount == 3) {
            this.newState = State.ALIVE;
        }
    }
    void update() {
        this.state = this.newState;
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
