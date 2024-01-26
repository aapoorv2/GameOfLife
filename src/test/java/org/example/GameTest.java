//package org.example;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class GameTest {
//    @Test
//    @DisplayName("Test if the next state of a 1 x 1 board is correct")
//    void testGetTheNextStateForA1by1With1() {
//        int[][] mockBoard = {{1}};
//        int[][] nextMockBoard = {{0}};
//        Game game = new Game(1, 1, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//    @Test
//    @DisplayName("Test if the next state of a 1 x 1 board having a 0 is correct")
//    void testGetTheNextStateForA1by1With0() {
//        int[][] mockBoard = {{0}};
//        int[][] nextMockBoard = {{0}};
//        Game game = new Game(1, 1, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//    @Test
//    @DisplayName("Test if the next state of a 2 x 2 board is correct")
//    void testGetTheNextStateForA2by2() {
//        int[][] mockBoard = {{1, 1}, {1, 0}};
//        int[][] nextMockBoard = {{1, 1}, {1, 1}};
//        Game game = new Game(2, 2, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//    @Test
//    @DisplayName("Test if the next state of a 3 x 3 board is correct")
//    void testGetTheNextStateForA3by3() {
//        int[][] mockBoard = {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}};
//        int[][] nextMockBoard = {{1, 1, 0}, {1, 0, 1}, {0, 1, 1}};
//        Game game = new Game(3, 3, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//    @Test
//    @DisplayName("Test if the next state of a 4 x 3 board is correct")
//    void testGetTheNextStateForA4by3() {
//        int[][] mockBoard = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
//        int[][] nextMockBoard = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}};
//        Game game = new Game(4, 3, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//    @Test
//    @DisplayName("Test if the next state of a 4 x 4 board is correct")
//    void testGetTheNextStateForA4by4() {
//        int[][] mockBoard = {{1, 0, 1, 1}, {0, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 0, 1}};
//        int[][] nextMockBoard = {{0, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 0, 0}};
//        Game game = new Game(4, 4, mockBoard);
//        assertArrayEquals(nextMockBoard, game.generateNextState());
//
//    }
//
//}