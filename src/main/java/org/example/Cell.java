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

    }
}
