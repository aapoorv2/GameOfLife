package org.example;

public class Game {
    private final Board board;

    Game(int rows, int columns, int fillPercent) {
        this.board = new Board(rows, columns, fillPercent);
    }
    void start() throws InterruptedException {
        int aliveCellsCount = board.countAliveCells();
        int generation = 1;
        board.print(generation);
        while (aliveCellsCount > 0) {
            board.update();
            aliveCellsCount = board.countAliveCells();
            Thread.sleep(1000);
            generation++;
            board.print(generation);
        }
    }

}
