package org.example;

import org.example.exceptions.InvalidDimensionsException;
import org.example.exceptions.InvalidSeedException;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;
    private final BoardInitializer boardInitializer;
    private final CellularAutomata cellularAutomata;

    Board(int rows, int columns, int fillPercent) {
        if (rows <= 0 || columns <= 0) {
            throw new InvalidDimensionsException();
        }
        if (fillPercent < 0) {
            throw new InvalidSeedException();
        }
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
        this.boardInitializer = new BoardInitializer(cells);
        this.cellularAutomata = new CellularAutomata(cells);
        boardInitializer.initializeBoard(fillPercent);

    }
    void update() {
        this.cells = cellularAutomata.evolve();
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
        if (count == 0) {
            InputOutput.instance().printAllCellsAreDead();
        }
        return count;
    }
    void print(int generation) {
        InputOutput.instance().printBoard(cells, rows, columns, generation);
    }
}
