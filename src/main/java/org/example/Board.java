package org.example;

import org.example.exceptions.InvalidDimensionsException;
import org.example.exceptions.InvalidSeedException;

public class Board {
    private final int rows;
    private final int columns;
    private final Cell[][] cells;
    private final BoardInitializer boardInitializer;
    private final EvolveEngine evolveEngine;

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
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                cells[i][j] = new Cell(new DeadState());
            }
        }
        this.boardInitializer = new BoardInitializer(cells);
        this.evolveEngine = new EvolveEngine(cells);
        boardInitializer.initializeBoard(fillPercent);

    }
    void update() {
        evolveEngine.evolve();
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


    void print(int generation) {
        InputOutput.instance().printBoard(cells, rows, columns, generation);
    }
}
