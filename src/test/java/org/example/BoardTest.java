package org.example;

import org.example.exceptions.InvalidDimensionsException;
import org.example.exceptions.InvalidSeedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    @DisplayName("if the number of Rows or Columns are negative, throw an exception")
    void testThrowingAnExceptionWhenPassingNonPositiveDimensions() {
        assertThrows(InvalidDimensionsException.class, () -> {
            Board board = new Board(-11, -2, 1);
        });
    }
    @Test
    @DisplayName("if the number of Rows or Columns are negative, throw an exception")
    void testThrowingAnExceptionWhenPassingNegativeFillPercentage() {
        assertThrows(InvalidSeedException.class, () -> {
            Board board = new Board(10, 2, -9);
        });
    }
    @Test
    @DisplayName("Rows are 10, Columns are, 10 and Fill Percentage is 100, then Alive Cells must be 100")
    void testCountOfAliveCellsWith10Rows10ColsAndSeedPercent100() {
        Board board = new Board(10, 10, 100);
        assertEquals(100, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 10, Columns are 15, and Fill Percentage is 20, then Alive Cells must be 30")
    void testCountOfAliveCellsWith10Rows15ColsAndSeedPercent20() {
        Board board = new Board(10, 15, 20);
        assertEquals(30, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 43, Columns are 20, and Fill Percentage is 28, then Alive Cells must be 240")
    void testCountOfAliveCellsWith43Rows20ColsAndSeedPercent28() {
        Board board = new Board(43, 20, 28);
        assertEquals(240, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 5, Columns are 9, and Fill Percentage is 31, then Alive Cells must be 13")
    void testCountOfAliveCellsWith5Rows9ColsAndSeedPercent31() {
        Board board = new Board(5, 9, 31);
        assertEquals(13, board.countAliveCells());
    }
    @Test
    @DisplayName("Rows are 5, Columns are 15, and Fill Percentage is 0, then Alive Cells must be 0")
    void testCountOfAliveCellsWith5Rows15ColsAndSeedPercent0() {
        Board board = new Board(5, 15, 0);
        assertEquals(0, board.countAliveCells());
    }
    @Test
    public void testRetrieveNeighboursOfCellAtPosition1_1() {
        int rows = 3;
        int columns = 3;
        int fillPercent = 50;
        Board board = new Board(rows, columns, fillPercent);

        List<Cell> neighbours = board.retrieveNeighboursOfCell(1, 1);

        assertEquals(8, neighbours.size());
    }
    @Test
    public void testRetrieveNeighboursOfCellAtPosition0_0() {
        int rows = 3;
        int columns = 3;
        int fillPercent = 50;
        Board board = new Board(rows, columns, fillPercent);

        List<Cell> neighbours = board.retrieveNeighboursOfCell(0, 0);

        assertEquals(3, neighbours.size());
    }


}