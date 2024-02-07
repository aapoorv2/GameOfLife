package org.example;

import java.util.List;

public class Cell {
    private final CellState state;

    Cell(CellState state) {
        this.state = state;
    }
    boolean isAlive() {
        return state.isAlive();
    }

    Cell evolve(int aliveNeighboursCount) {
        return state.evolve(aliveNeighboursCount);
    }
    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (!(other instanceof Cell c))
            return false;
        return c.isAlive() == this.isAlive();
    }
}
