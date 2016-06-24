package com.wouter.kata.bowlinggame;

/**
 * Code Kata: Bowling Game
 *
 */
public class Bowling
{

    private int score = 0;
    private int[] allRolls = new int[21];
    private int currentRoll = 0;

    public int getScore() {
        int roll = 0;
        for (int i = 0; i < 21; i++) {
            if (isStrike(allRolls[roll])){
                score += 10 + allRolls[roll + 1] + allRolls[roll + 2];
            }else {
                score+= allRolls[roll];
            }
            roll++;
        }
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    public void roll(int pins) {
        allRolls[currentRoll++] = pins;
    }
}
