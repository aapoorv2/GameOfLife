package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testIsAliveMethodWhenCellIsAlive() {
        Cell cell = new Cell(State.ALIVE);
        assertTrue(cell.isAlive());
    }
    @Test
    void testIsAliveMethodWhenCellIsDead() {
        Cell cell = new Cell(State.DEAD);
        assertFalse(cell.isAlive());
    }
    @Test
    void testCountAliveNeighboursWith4AliveCells() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);
        Cell cell4 = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);

        assertEquals(4, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4))));
    }
    @Test
    void testCountAliveNeighboursWith1AliveCell() {
        Cell cell1 = new Cell(State.DEAD);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.DEAD);
        Cell cell = new Cell(State.DEAD);
        Cell[] neighbours = {cell1, cell2, cell3};
        assertEquals(1, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(cell1, cell2, cell3))));
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);
        Cell cell4 = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);
        Cell cell4 = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3, cell4)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        cell.update();
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.ALIVE);
        Cell cell3 = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        cell.update();
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(State.ALIVE);
        Cell cell2 = new Cell(State.DEAD);
        Cell cell3 = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWithNoAliveNeighboursAndCurrentCellAlive() {
        Cell cell1 = new Cell(State.DEAD                    );
        Cell cell2 = new Cell(State.DEAD);
        Cell cell3 = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(cell1, cell2, cell3)));
        cell.update();
        assertFalse(cell.isAlive());
    }

}