package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;
    private final int fillPercent;

    Board(int rows, int columns, int fillPercent) {
        if (rows <= 0 || columns <= 0 || fillPercent < 0) {
            throw new RuntimeException();
        }
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = fillPercent;
        this.cells = new Cell[rows][columns];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                cells[i][j] = new Cell(State.DEAD);
            }
        }
        initializeBoard();

    }

    void initializeBoard() {
        int filled = 0;
        int total = (this.fillPercent * this.rows * this.columns) / 100;
        while (filled < total) {
            Random rand = new Random();
            int i = rand.nextInt(rows);
            int j = rand.nextInt(columns);
            if (!cells[i][j].isAlive()) {
                cells[i][j] = new Cell(State.ALIVE);
                filled++;
            }
        }

    }
    void update() {
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

    int countAliveCells() {
        int count = 0;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                if (cells[i][j].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    List<Cell> retrieveNeighboursOfCell(int row, int col) {
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
    void print(int generation) {
        InputOutput.instance().printBoard(cells, rows, columns, generation);
    }
}
