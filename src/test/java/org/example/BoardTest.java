package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("if the number of Rows or Columns, or the fill percentage are negative, throw and exception")
    void testNonNegativeValues() {
        assertThrows(RuntimeException.class, () -> {
            Board board = new Board(-11, -2, -10);
        });
    }
    @Test
    @DisplayName("Rows are 10, Columns are, 10 and Fill Percentage is 100, then Alive Cells must be 100")
    void testCountOfAliveCells1() {
        Board board = new Board(10, 10, 100);
        assertEquals(100, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 10, Columns are 15, and Fill Percentage is 20, then Alive Cells must be 30")
    void testCountOfAliveCells2() {
        Board board = new Board(10, 15, 20);
        assertEquals(30, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 43, Columns are 20, and Fill Percentage is 28, then Alive Cells must be 240")
    void testCountOfAliveCells3() {
        Board board = new Board(43, 20, 28);
        assertEquals(240, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 5, Columns are 9, and Fill Percentage is 31, then Alive Cells must be 13")
    void testCountOfAliveCells4() {
        Board board = new Board(5, 9, 31);
        assertEquals(13, board.countAliveCells());
    }

    @Test
    @DisplayName("Testing Neighbouring cells count of the Top left corner")
    void testCountAliveNeighboursTopLeftCorner() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        Board board = new Board(4, 4, mockBoard);
        assertEquals(1, board.countAliveNeighbours(0, 0));
    }
    @Test
    @DisplayName("Testing Neighbouring cells count of the Top Right corner")
    void testCountAliveNeighboursTopRightCorner() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        Board board = new Board(4, 4, mockBoard);
        assertEquals(3, board.countAliveNeighbours(0, 3));
    }
    @Test
    @DisplayName("Testing Neighbouring cells count of the Bottom Right corner")
    void testCountAliveNeighboursBottomRightCorner() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        Board board = new Board(4, 4, mockBoard);
        assertEquals(0, board.countAliveNeighbours(3, 3));
    }
    @Test
    @DisplayName("Testing Neighbouring cells count of the Bottom Left corner")
    void testCountAliveNeighboursBottomLeftCorner() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        Board board = new Board(4, 4, mockBoard);
        assertEquals(2, board.countAliveNeighbours(3, 0));
    }
    @Test
    @DisplayName("Testing Neighbouring cells count of a non-corner")
    void testCountAliveNeighboursNonCorner() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        Board board = new Board(4, 4, mockBoard);
        assertEquals(4, board.countAliveNeighbours(1, 2));
    }
}