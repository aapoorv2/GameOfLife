package org.example;

import java.util.Random;

public class BoardInitializer {
    private final Cell[][] cells;
    BoardInitializer(Cell[][] cells) {
        this.cells = cells;
    }
    void initializeBoard(int fillPercent) {
        int rows = cells.length;
        int columns = cells[0].length;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                cells[i][j] = new Cell(new DeadState());
            }
        }
        int filled = 0;
        int total = (fillPercent * rows * columns) / 100;
        while (filled < total) {
            Random rand = new Random();
            int i = rand.nextInt(rows);
            int j = rand.nextInt(columns);
            if (!cells[i][j].isAlive()) {
                cells[i][j] = new Cell(new AliveState());
                filled++;
            }
        }

    }
}
