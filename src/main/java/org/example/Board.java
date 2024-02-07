package org.example;

import org.example.exceptions.InvalidDimensionsException;
import org.example.exceptions.InvalidSeedException;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;
    private final BoardInitializer boardInitializer;
    private final EvolutionEngine evolutionEngine;

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
        this.evolutionEngine = new EvolutionEngine(cells);
        boardInitializer.initializeBoard(fillPercent);

    }
    void update() {
        cells = evolutionEngine.evolve();
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
