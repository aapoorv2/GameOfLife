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
    Game(int rows, int columns, int[][] board) {
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = 0;
        this.board = new Board(rows, columns, board);
        this.aliveCells = this.board.countAliveCells();
    }
//    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
//    Any live cell with two or three live neighbours lives on to the next generation.
//    Any live cell with more than three live neighbours dies, as if by overpopulation.
//    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
    int[][] generateNextState() {
        int[][] nextBoard = new int[rows][columns];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                int aliveNeighbours = board.countAliveNeighbours(i, j);
                if (board.get(i, j) == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3)) {
                    nextBoard[i][j] = 0;
                    aliveCells--;
                } else if (board.get(i, j) == 0 && aliveNeighbours == 3) {
                    nextBoard[i][j] = 1;
                    aliveCells++;
                } else nextBoard[i][j] = board.get(i, j);
            }
        }
        return nextBoard;
    }
    void start() throws InterruptedException {
        board.print();
        while (aliveCells > 0) {
            int[][] nextBoard = generateNextState();
            for (int i = 0 ; i < rows ; i++) {
                for (int j = 0 ; j < columns ; j++) {
                    board.set(i, j, nextBoard[i][j]);
                }
            }
            Thread.sleep(1000);
            board.print();
        }
    }


}
