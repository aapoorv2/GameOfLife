package org.example;

public class Cell {
    private final int row;
    private final int column;
    private State state = State.DEAD;
    Cell(int row, int column, State state) {
        this.row = row;
        this.column = column;
        this.state = state;
    }
    boolean isAlive() {
        return state == State.ALIVE;
    }

    void applyRules(Cell[] neighbours) {
        int aliveCount = countAliveNeighbours(neighbours);
        if (isAlive() && (aliveCount < 2 || aliveCount > 3)) {
            this.state = State.DEAD;
        } else if (!isAlive() && aliveCount == 3) {
            this.state = State.ALIVE;
        }
    }
    int countAliveNeighbours(Cell[] neighbours) {
        int countAlive = 0;
        for (Cell cell : neighbours) {
            if(cell.isAlive()) {
                countAlive++;
            }
        }
        return countAlive;
    }
}
