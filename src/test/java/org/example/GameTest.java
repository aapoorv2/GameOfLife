package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("Count alive neighbours")
    void testCountAliveNeighbours() {
        Game game = new Game(10, 10, 10);

    }

}