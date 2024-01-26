package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    @DisplayName("Test if the cell is alive and returns true")
    void testIsAliveMethod() {
        Cell cell = new Cell(0, 0, State.ALIVE);
        assertTrue(cell.isAlive());
    }

}