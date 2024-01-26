package org.example;

public class Game {
    private final int rows;
    private final int columns;
    private final int fillPercent;
    private Board board;

    Game(int rows, int columns, int fillPercent) {
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = fillPercent;
        this.board = new Board(rows, columns, fillPercent);

    }
    Game(int rows, int columns, Cell[][] cells) {
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = 0;
        this.board = new Board(rows, columns, cells);

    }
    void start() {
        int aliveCellsCount = board.countAliveCells();
        while (aliveCellsCount > 0) {
            board.update();
            aliveCellsCount = board.countAliveCells();
            board.print();
        }
    }
//    int[][] generateNextState() {
//        int[][] nextBoard = new int[rows][columns];
//        for (int i = 0 ; i < rows ; i++) {
//            for (int j = 0 ; j < columns ; j++) {
//                int aliveNeighbours = board.countAliveNeighbours(i, j);
//                if (board.get(i, j) == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3)) {
//                    nextBoard[i][j] = 0;
//                    aliveCells--;
//                } else if (board.get(i, j) == 0 && aliveNeighbours == 3) {
//                    nextBoard[i][j] = 1;
//                    aliveCells++;
//                } else nextBoard[i][j] = board.get(i, j);
//            }
//        }
//        return nextBoard;
//    }
//    void start() throws InterruptedException {
//        board.print();
//        while (aliveCells > 0) {
//            int[][] nextBoard = generateNextState();
//            for (int i = 0 ; i < rows ; i++) {
//                for (int j = 0 ; j < columns ; j++) {
//                    board.set(i, j, nextBoard[i][j]);
//                }
//            }
//            Thread.sleep(1000);
//            board.print();
//        }
//    }


}
