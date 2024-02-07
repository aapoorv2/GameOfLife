package org.example;

public class CellularAutomata {
    private Cell[][] cells;
    private final int rows;
    private final int columns;
    CellularAutomata(Cell[][] cells) {
        this.rows = cells.length;
        this.columns = cells[0].length;
        this.cells = cells;
    }
    Cell[][] evolve() {
        Cell[][] nextGenerationCells = new Cell[rows][columns];
        for (int i = 0 ; i < this.rows ; i++) {
            for (int j = 0 ; j < this.columns ; j++) {
                nextGenerationCells[i][j] = this.cells[i][j].evolve(countAliveNeighbours(i, j));
            }
        }
        cells = nextGenerationCells;
        return nextGenerationCells;
    }
    private int countAliveNeighbours(int row, int col) {
        int countAlive = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0 ; i < 8 ; i++) {
            int nRow = row + dirs[i][0];
            int nCol = col + dirs[i][1];
            if (nRow < 0 || nRow == rows || nCol < 0 || nCol == columns) {
                continue;
            }
            if (this.cells[nRow][nCol].isAlive())
                countAlive++;
        }
        return countAlive;
    }

}
