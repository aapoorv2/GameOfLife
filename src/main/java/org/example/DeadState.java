package org.example;

import java.util.List;

public class DeadState implements CellState {
    @Override
    public Cell evolve(List<Cell> neighbours) {
        int aliveCount = countAliveNeighbours(neighbours);
        if (aliveCount == 3)
            return new Cell(new AliveState());
        return new Cell(this);
    }

    @Override
    public boolean isAlive() {
        return false;
    }
}
