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
        Cell cell = new Cell(new AliveState());

        Cell nextCell = cell.evolve(4);

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith4AliveNeighboursAndCurrentCellDead() {
        Cell cell = new Cell(new DeadState());

        Cell nextCell = cell.evolve(4);

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellDead() {
        Cell cell = new Cell(new DeadState());

        Cell nextCell = cell.evolve(3);

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith3AliveNeighboursAndCurrentCellAlive() {
        Cell cell = new Cell(new AliveState());

        Cell nextCell = cell.evolve(3);

        assertTrue(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWith1AliveNeighboursAndCurrentCellAlive() {
        Cell cell = new Cell(new AliveState());

        Cell nextCell = cell.evolve(1);

        assertFalse(nextCell.isAlive());
    }
    @Test
    void testApplyRulesWithNoAliveNeighboursAndCurrentCellAlive() {
        Cell cell = new Cell(new AliveState());

        Cell nextCell = cell.evolve(0);

        assertFalse(nextCell.isAlive());
    }

}