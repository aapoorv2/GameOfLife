package org.example;

import java.util.ArrayList;
import java.util.List;

public class Evolver {
    private final Cell[][] cells;
    Evolver(Cell[][] cells) {
        this.cells = cells;
    }
    void evolveCells() {
        int rows = cells.length;
        int columns = cells[0].length;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                List<Cell> neighbours = retrieveNeighboursOfCell(i, j);
                cells[i][j].applyRules(neighbours);
            }
        }
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                cells[i][j].update();
            }
        }
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
