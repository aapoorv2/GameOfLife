package org.example;

import java.util.List;

public class DeadState implements CellState {
    @Override
    public Cell evolve(int aliveNeighboursCount) {
        if (aliveNeighboursCount == 3)
            return new Cell(new AliveState());
        return new Cell(this);
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
