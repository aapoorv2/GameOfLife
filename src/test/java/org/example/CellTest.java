package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    @DisplayName("Test if the cell is alive and returns true")
    void testIsAliveMethodWhenCellIsAlive() {
        Cell cell = new Cell(0, 0, State.ALIVE);
        assertTrue(cell.isAlive());
    }
    @Test
    @DisplayName("Test if the cell is dead and returns false")
    void testIsAliveMethodWhenCellIsDead() {
        Cell cell = new Cell(0, 0, State.DEAD);
        assertFalse(cell.isAlive());
    }

}