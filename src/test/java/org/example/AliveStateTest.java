package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliveStateTest {
    @Test
    void testAliveStateCellIsAlive() {
        AliveState cell = new AliveState();

        boolean isAlive = cell.isAlive();

        assertTrue(isAlive);
    }

}