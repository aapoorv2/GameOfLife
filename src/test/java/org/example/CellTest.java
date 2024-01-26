package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testIsAliveMethodWhenCellIsAlive() {
        Cell cell = new Cell(0, 0, State.ALIVE);
        assertTrue(cell.isAlive());
    }
    @Test
    void testIsAliveMethodWhenCellIsDead() {
        Cell cell = new Cell(0, 0, State.DEAD);
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRules() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(0, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell4 = new Cell(2, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.ALIVE);
        Cell[] neighbours = {cell1, cell2, cell3, cell4};
        cell.applyRules(neighbours);
        assertFalse(cell.isAlive());

    }

}