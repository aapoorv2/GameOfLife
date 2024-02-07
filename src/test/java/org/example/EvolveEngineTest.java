package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvolveEngineTest {
    @Test
    public void testRetrieveNeighboursOfCellAtPosition1_1() {
        Cell[][] cells = new Cell[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                cells[i][j] = new Cell(new DeadState());
            }
        }
        EvolveEngine evolveEngine = new EvolveEngine(cells);
        List<Cell> neighbours = evolveEngine.retrieveNeighboursOfCell(1, 1);

        assertEquals(8, neighbours.size());
    }
    @Test
    public void testRetrieveNeighboursOfCellAtPosition0_0() {
        Cell[][] cells = new Cell[3][3];
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                cells[i][j] = new Cell(new DeadState());
            }
        }
        EvolveEngine evolveEngine = new EvolveEngine(cells);
        List<Cell> neighbours = evolveEngine.retrieveNeighboursOfCell(0, 0);

        assertEquals(3, neighbours.size());
    }

}