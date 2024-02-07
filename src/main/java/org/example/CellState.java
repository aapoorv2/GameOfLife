package org.example;

import java.util.List;

public interface CellState {
    Cell evolve(int aliveNeighboursCount);
    boolean isAlive();

}
