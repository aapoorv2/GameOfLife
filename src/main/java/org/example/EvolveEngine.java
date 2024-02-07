package org.example;

import java.util.ArrayList;
import java.util.List;

public class EvolveEngine {
    private Cell[][] cells;
    EvolveEngine(Cell[][] cells) {
        this.cells = cells;
    }
    void evolve() {
        int rows = cells.length;
        int columns = cells[0].length;
        Cell[][] nextCells = new Cell[rows][columns];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                List<Cell> neighbours = retrieveNeighboursOfCell(i, j);
                nextCells[i][j] = cells[i][j].evolve(neighbours);
            }
        }
        cells = nextCells;
    }
    List<Cell> retrieveNeighboursOfCell(int row, int col) {
        int rows = cells.length;
        int columns = cells[0].length;
        List<Cell> neighbours = new ArrayList<>();
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0 ; i < 8 ; i++) {
            int nRow = row + dirs[i][0];
            int nCol = col + dirs[i][1];
            if (nRow < 0 || nRow == rows || nCol < 0 || nCol == columns) {
                continue;
            }
            neighbours.add(cells[nRow][nCol]);
        }
        return neighbours;
    }
}
