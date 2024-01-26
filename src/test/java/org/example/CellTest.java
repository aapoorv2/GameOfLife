package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        assertEquals(4, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4))));
    }
    @Test
    void testCountAliveNeighboursWith1AliveCells() {
        Cell cell1 = new Cell(0, 0, State.DEAD);
        Cell cell2 = new Cell(2, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 4, State.DEAD);
        Cell cell = new Cell(1, 1, State.DEAD);
        Cell[] neighbours = {cell1, cell2, cell3};
        assertEquals(1, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(cell1, cell2, cell3))));
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(0, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell4 = new Cell(2, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4)));
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(0, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell4 = new Cell(2, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4)));
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(2, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(2, 1, State.ALIVE);
        Cell cell3 = new Cell(1, 0, State.ALIVE);
        Cell cell = new Cell(1, 1, State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(0, 0, State.ALIVE);
        Cell cell2 = new Cell(2, 1, State.DEAD);
        Cell cell3 = new Cell(1, 0, State.DEAD);
        Cell cell = new Cell(1, 1, State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        assertFalse(cell.isAlive());
    }

}