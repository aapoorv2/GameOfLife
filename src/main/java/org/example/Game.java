package org.example;

public class Game {
    private final Board board;

    Game(int rows, int columns, int fillPercent) {
        this.board = new Board(rows, columns, fillPercent);
    }
    void start() throws InterruptedException {
        int generation = 1;
        while (board.countAliveCells() > 0) {
            board.print(generation);
            board.update();
            Thread.sleep(1000);
        }
    }

}
