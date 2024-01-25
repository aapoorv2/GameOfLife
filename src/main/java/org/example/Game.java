package org.example;

public class Game {
    private final int rows;
    private final int columns;
    private final int fillPercent;
    private int aliveCells;
    private Board board;
    Game(int rows, int columns, int fillPercent) {
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = fillPercent;
        this.board = new Board(rows, columns, fillPercent);
        this.aliveCells = this.board.countAliveCells();
    }

    void start() {
        while (aliveCells > 0) {
             break;
        }

    }


}
