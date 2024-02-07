package org.example;

import java.util.List;

public class Cell {
    private CellState state;

    Cell(CellState state) {
        this.state = state;
    }
    boolean isAlive() {
        state.isAlive();
    }

    Cell evolve(List<Cell> neighbours) {
        state.evolve(neighbours);
    }

}
