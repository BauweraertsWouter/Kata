package com.wouter.kata.bowlinggame;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Bowling.
 */
public class BowlingTest
{

    private Bowling game;

    @Before
    public void setUp() throws Exception {
        game = new Bowling();
    }

    @Test
    public void testScore(){
        Assert.assertEquals(0, game.getScore());
    }

    @Test
    public void allZeroes(){
        int rolls = 20;
        int pins = 0;
        rollMany(rolls, pins);
        Assert.assertEquals(0, game.getScore());
    }

    @Test
    public void allOnes(){
        int rolls = 20;
        int pins = 1;
        rollMany(rolls, pins);
        Assert.assertEquals(20, game.getScore());
    }

    @Test
    public void rollStrike(){
        game.roll(10);
        game.roll(4);
        game.roll(3);
        rollMany(16, 0);

        Assert.assertEquals(24, game.getScore());
    }

    @Test
    public void rollSpare(){
        game.roll(4);
        game.roll(6);
        game.roll(1);
        rollMany(16, 0);

        Assert.assertEquals(12, game.getScore());
    }

    @Test
    public void perfectTest(){
        rollMany(12,10);
        Assert.assertEquals(300,game.getScore());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }
}
