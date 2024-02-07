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
        assertEquals(1, cell.countAliveNeighbours(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell))));
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell fourthCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));
        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell fourthCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.DEAD);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.ALIVE);
        Cell thirdCell = new Cell(State.ALIVE);
        Cell cell = new Cell(State.ALIVE);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.ALIVE);
        Cell secondCell = new Cell(State.DEAD);
        Cell thirdCell = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWithNoAliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(State.DEAD                    );
        Cell secondCell = new Cell(State.DEAD);
        Cell thirdCell = new Cell(State.DEAD);
        Cell cell = new Cell(State.ALIVE);
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertFalse(nextCell.isAlive());
    }

}