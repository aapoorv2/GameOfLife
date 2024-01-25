package org.example;

import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private int[][] board;
    private final int fillPercent;

    Board(int rows, int columns, int fillPercent) {
        if (rows < 0 || columns < 0 || fillPercent < 0) {
            throw new RuntimeException();
        }
        this.rows = rows;
        this.columns = columns;
        this.fillPercent = fillPercent;
        this.board = new int[rows][columns];
        initialize_board();

    }
    Board(int rows, int columns, int[][] board) {
        this.rows = rows;
        this.columns = columns;
        this.board = board;
        this.fillPercent = 0;
    }

    void initialize_board() {
        int filled = 0;
        int total = (this.fillPercent * this.rows * this.columns) / 100;
        while (filled < total) {
            Random rand = new Random();
            int i = rand.nextInt(rows);
            int j = rand.nextInt(columns);
            if (board[i][j] == 0) {
                board[i][j] = 1;
                filled++;
            }
        }
    }

    int countAliveCells() {
        int count = 0;
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                count += board[i][j];
            }
        }
        return count;
    }

    int countAliveNeighbours(int row, int col) {
        int count = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int i = 0 ; i < 8 ; i++) {
            int nRow = row + dirs[i][0];
            int nCol = col + dirs[i][1];
            if (nRow < 0 || nRow == rows || nCol < 0 || nCol == columns) {
                continue;
            }
            count += board[nRow][nCol];
        }
        return count;
    }
    int get(int row, int column) {
        return board[row][column];
    }
    void set(int row, int column, int value) {
        board[row][column] = value;
    }
    void print() {
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                if (board[i][j] == 1){
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
