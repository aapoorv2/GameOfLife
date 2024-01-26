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
    void testCountAliveNeighboursWith4AliveCells() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(0, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell4 = new Cell(2, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.ALIVE);
        Cell[] neighbours = {cell1, cell2, cell3, cell4};
        assertEquals(4, cell.countAliveNeighbours(neighbours));
    }
    @Test
    void testCountAliveNeighboursWith1AliveCells() {
        Cell cell1 = new Cell(0, 0, State.DEAD);
        Cell cell2 = new Cell(2, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 4, State.DEAD);
        Cell cell = new Cell(1, 1, State.DEAD);
        Cell[] neighbours = {cell1, cell2, cell3};
        assertEquals(1, cell.countAliveNeighbours(neighbours));
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
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