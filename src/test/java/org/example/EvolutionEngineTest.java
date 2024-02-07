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


}