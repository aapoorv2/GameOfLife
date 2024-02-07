package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvolutionEngineTest {
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
        EvolutionEngine evolutionEngine = new EvolutionEngine(cells);

        Cell[][] nextCells = evolutionEngine.evolve();

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
        EvolutionEngine evolutionEngine = new EvolutionEngine(cells);

        Cell[][] secondGenerationCells = evolutionEngine.evolve();
        Cell[][] thirdGenerationCells = evolutionEngine.evolve();

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
        Cell[][] expectedSecondGenerationCells = new Cell[][] {
                {new Cell(new AliveState()), new Cell(new AliveState())},
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new AliveState()), new Cell(new AliveState())}
        };
        Cell[][] expectedThirdGenerationCells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())}
        };
        Cell[][] expectedFourthGenerationCells = new Cell[][] {
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())},
                {new Cell(new DeadState()), new Cell(new DeadState())}
        };
        EvolutionEngine evolutionEngine = new EvolutionEngine(cells);

        Cell[][] secondGenerationCells = evolutionEngine.evolve();
        Cell[][] thirdGenerationCells = evolutionEngine.evolve();
        Cell[][] fourthGenerationCells = evolutionEngine.evolve();

        assertArrayEquals(expectedSecondGenerationCells, secondGenerationCells);
        assertArrayEquals(expectedThirdGenerationCells, thirdGenerationCells);
        assertArrayEquals(expectedFourthGenerationCells, fourthGenerationCells);
    }


}