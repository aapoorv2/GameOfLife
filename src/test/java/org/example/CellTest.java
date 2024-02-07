package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testIsAliveMethodWhenCellIsAlive() {
        Cell cell = new Cell(new AliveState());
        assertTrue(cell.isAlive());
    }
    @Test
    void testIsAliveMethodWhenCellIsDead() {
        Cell cell = new Cell(new DeadState());
        assertFalse(cell.isAlive());
    }

    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(new AliveState());
        Cell secondCell = new Cell(new AliveState());
        Cell thirdCell = new Cell(new AliveState());
        Cell fourthCell = new Cell(new AliveState());
        Cell cell = new Cell(new AliveState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));
        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(new AliveState());
        Cell secondCell = new Cell(new AliveState());
        Cell thirdCell = new Cell(new AliveState());
        Cell fourthCell = new Cell(new AliveState());
        Cell cell = new Cell(new DeadState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell, fourthCell)));

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell firstCell = new Cell(new AliveState());
        Cell secondCell = new Cell(new AliveState());
        Cell thirdCell = new Cell(new AliveState());
        Cell cell = new Cell(new DeadState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(new AliveState());
        Cell secondCell = new Cell(new AliveState());
        Cell thirdCell = new Cell(new AliveState());
        Cell cell = new Cell(new AliveState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(new AliveState());
        Cell secondCell = new Cell(new DeadState());
        Cell thirdCell = new Cell(new DeadState());
        Cell cell = new Cell(new AliveState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWithNoAliveNeighboursAndCurrentCellAlive() {
        Cell firstCell = new Cell(new DeadState());
        Cell secondCell = new Cell(new DeadState());
        Cell thirdCell = new Cell(new DeadState());
        Cell cell = new Cell(new AliveState());
        Cell nextCell = cell.evolve(new ArrayList<>(Arrays.asList(firstCell, secondCell, thirdCell)));

        assertFalse(nextCell.isAlive());
    }

}