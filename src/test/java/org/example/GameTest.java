package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("Test if the next state of a 1 x 1 board is correct")
    void testCountAliveNeighboursFor1by1() {
        int[][] mockBoard = {{1}};
        int[][] nextMockBoard = {{0}};
        Game game = new Game(1, 1, mockBoard);
        assertArrayEquals(nextMockBoard, game.generateNextState());

    }
    @Test
    @DisplayName("Test if the next state of a 1 x 1 board with 0 is correct")
    void testCountAliveNeighboursFor1by1with0() {
        int[][] mockBoard = {{0}};
        int[][] nextMockBoard = {{0}};
        Game game = new Game(1, 1, mockBoard);
        assertArrayEquals(nextMockBoard, game.generateNextState());

    }
    @Test
    @DisplayName("Test if the next state of the board is correct")
    void testCountAliveNeighbours() {
        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
        int[][] nextMockBoard = {{0, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}};
        Game game = new Game(4, 4, mockBoard);
        assertArrayEquals(nextMockBoard, game.generateNextState());

    }

}