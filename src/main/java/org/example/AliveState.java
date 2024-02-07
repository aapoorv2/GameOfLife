package org.example;

import java.util.ArrayList;
import java.util.List;

public class AliveState implements CellState {
    @Override
    public Cell evolve(int aliveNeighboursCount) {
        if (aliveNeighboursCount < 2 || aliveNeighboursCount > 3)
            return new Cell(new DeadState());
        return new Cell(this);
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
