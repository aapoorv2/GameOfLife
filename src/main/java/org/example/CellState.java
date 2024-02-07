package org.example;

import java.util.List;

public interface CellState {
    Cell evolve(List<Cell> neighbours);
    boolean isAlive();
    default int countAliveNeighbours(List<Cell> neighbours) {
        int countAlive = 0;
        for (Cell cell : neighbours) {
            if(cell.isAlive()) {
                countAlive++;
            }
        }
        return countAlive;
    }
}
