package org.example;

import java.util.List;

public class Cell {
    private CellState state;

    Cell(CellState state) {
        this.state = state;
    }
    boolean isAlive() {
        return state.isAlive();
    }

    Cell evolve(List<Cell> neighbours) {
        return state.evolve(neighbours);
    }

}
