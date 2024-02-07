package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellularAutomataTest {
    @Test
    public void testEvolvingTheCellsFor1Iteration() {
        Cell[][] cells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        Cell[][] expectedNextCells = new Cell[][] {
                {new Cell(new AliveState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        CellularAutomata cellularAutomata = new CellularAutomata(cells);

        Cell[][] nextCells = cellularAutomata.evolve();

        assertArrayEquals(expectedNextCells, nextCells);
    }
    @Test
    public void testEvolvingTheCellsFor2Iterations() {
        Cell[][] cells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        Cell[][] expectedSecondGenerationCells = new Cell[][] {
                {new Cell(new AliveState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        Cell[][] expectedThirdGenerationCells = new Cell[][] {
                {new Cell(new AliveState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        CellularAutomata cellularAutomata = new CellularAutomata(cells);

        Cell[][] secondGenerationCells = cellularAutomata.evolve();
        Cell[][] thirdGenerationCells = cellularAutomata.evolve();

        assertArrayEquals(expectedSecondGenerationCells, secondGenerationCells);
        assertArrayEquals(expectedThirdGenerationCells, thirdGenerationCells);
    }
    @Test
    public void testEvolvingTheCellsFor3Iterations() {
        Cell[][] cells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        Cell[][] expectedFourthGenerationCells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())}
        };
        CellularAutomata cellularAutomata = new CellularAutomata(cells);

        cellularAutomata.evolve();
        cellularAutomata.evolve();
        Cell[][] fourthGenerationCells = cellularAutomata.evolve();

        assertArrayEquals(expectedFourthGenerationCells, fourthGenerationCells);
    }


}