package org.example;

import java.util.ArrayList;
import java.util.List;

public class EvolutionEngine {
    private Cell[][] cells;
    EvolutionEngine(Cell[][] cells) {
        this.cells = cells;
    }
    Cell[][] evolve() {
        int rows = cells.length;
        int columns = cells[0].length;
        Cell[][] nextCells = new Cell[rows][columns];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                nextCells[i][j] = cells[i][j].evolve(countAliveNeighbours(i, j));
            }
        }
        cells = nextCells;
        return nextCells;
    }
    private int countAliveNeighbours(int row, int col) {
        int rows = cells.length;
        int columns = cells[0].length;
        int countAlive = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0 ; i < 8 ; i++) {
            int nRow = row + dirs[i][0];
            int nCol = col + dirs[i][1];
            if (nRow < 0 || nRow == rows || nCol < 0 || nCol == columns) {
                continue;
            }
            if (cells[nRow][nCol].isAlive())
                countAlive++;
        }
        return countAlive;
    }
}
