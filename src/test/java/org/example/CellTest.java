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
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell fourthCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);

        assertEquals(4, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell))));
    }
    @Test
    void testCountAliveNeighboursWith1AliveCell() {
        Cell firstCell = new Cell(State.DEAD);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.DEAD);
        Cell cell = new Cell(State.DEAD);
        Cell[] neighbours = {firstCell, secondCell, thirdCell};
        assertEquals(1, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell))));
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell fourthCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell fourthCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));
        cell.update();
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));
        cell.update();
        assertTrue(cell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.DEAD);
        Cell thirdCell = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));
        cell.update();
        assertFalse(cell.isAlive());
    }
    @Test
    void testApplyRulesWithNoAliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.DEAD                    );
        Cell secondCell = new Cell(State.DEAD);
        Cell thirdCell = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        cell.applyRules(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));
        cell.update();
        assertFalse(cell.isAlive());
    }

}