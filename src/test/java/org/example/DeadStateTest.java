package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadStateTest {
    @Test
    void testDeadStateCellIsDead() {
        DeadState cell = new DeadState();

        boolean isAlive = cell.isAlive();

        assertFalse(isAlive);
    }

}