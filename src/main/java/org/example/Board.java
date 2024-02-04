package org.example;

import org.example.exceptions.InvalidDimensionsException;
import org.example.exceptions.InvalidSeedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private final Cell[][] cells;
    private final BoardInitializer boardInitializer;
    private final Evolver evolver;

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
                cells[i][j] = new Cell(State.DEAD);
            }
        }
        this.boardInitializer = new BoardInitializer(cells);
        this.evolver = new Evolver(cells);
        boardInitializer.initializeBoard(fillPercent);

    }
    void update() {
        evolver.evolveCells();
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
