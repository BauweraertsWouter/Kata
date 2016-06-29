package com.wouter.kata.gameOfLife;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Wouter on 29/06/2016.
 */
public class GameOfLifeTest {
    GameOfLife gol;
    private int[][] matrix;

    @Before
    public void init() {
        matrix = new int[4][];
        matrix[0] = new int[]{0,1,0,0,0,0,0,0};
        matrix[1] = new int[]{0,0,0,0,1,0,0,0};
        matrix[2] = new int[]{0,0,0,1,1,1,0,0};
        matrix[3] = new int[]{0,0,0,0,1,0,0,0};
        gol = new GameOfLife();
    }

    @Test
    public void getCellStatusTest(){
        init();
        assertEquals(0,gol.getCellStatus(matrix[1][3]));
        assertEquals(1,gol.getCellStatus(matrix[1][4]));
    }

    @Test
    public void countLiveNeighbours(){
        //counts the amount of live neighbours of a specified cell in the current generation
        assertEquals(1, gol.countNeighbours(1, matrix, 0, 0));
        assertEquals(0, gol.countNeighbours(1, matrix, 0, 7));
        assertEquals(0, gol.countNeighbours(1, matrix, 3, 0));
        assertEquals(0, gol.countNeighbours(1, matrix, 3, 7));
        assertEquals(4, gol.countNeighbours(1, matrix, 2, 4));
    }

    @Test
    public void countDeadNeighbours(){
        assertEquals(2, gol.countNeighbours(0, matrix, 0, 0));
        assertEquals(3, gol.countNeighbours(0, matrix, 0, 7));
        assertEquals(3, gol.countNeighbours(0, matrix, 3, 0));
        assertEquals(3, gol.countNeighbours(0, matrix, 3, 7));
        assertEquals(4, gol.countNeighbours(0, matrix, 2, 4));
    }

    @Test
    public void underpopulationTest(){
        assertEquals(1, gol.kill(matrix, 2, 3));
        assertEquals(0, gol.kill(matrix, 0, 1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void underpopulationDeadCell(){
        assertEquals(-1, gol.kill(matrix, 0, 0));
    }

    @Test
    public void overcrowdingTest(){
        assertEquals(1, gol.kill(matrix, 2, 3));
        assertEquals(0, gol.kill(matrix, 2, 4));
    }

    @Test (expected = IllegalArgumentException.class)
    public void overcrowdingDeadCell(){
        assertEquals(-1, gol.kill(matrix, 0,0));
    }

    @Test
    public void stayAlive(){
        assertEquals(1, gol.kill(matrix, 2,3));
        assertEquals(0, gol.kill(matrix, 0,1));
    }

    @Test (expected = IllegalArgumentException.class)
    public void stayAliveDeadCell(){
        assertEquals(-1, gol.kill(matrix, 0,7));
    }

    @Test
    public void makeAlive(){
        assertEquals(0, gol.cellAlive(matrix, 0,7));
        assertEquals(1, gol.cellAlive(matrix, 1,3));
    }

    @Test (expected = IllegalArgumentException.class)
    public void makeAliveLiveCell(){
        assertEquals(-1, gol.cellAlive(matrix, 0,1));
    }

    @Test
    public void nextGeneration(){
        int[][] nextGen = new int[matrix.length][];
        nextGen[0] = new int[] {0,0,0,0,0,0,0,0};
        nextGen[1] = new int[] {0,0,1,1,1,1,0,0};
        nextGen[2] = new int[] {0,0,0,1,0,1,0,0};
        nextGen[3] = new int[] {0,0,0,1,1,1,0,0};
        assertArrayEquals(nextGen, gol.nextGen(matrix));
    }
}