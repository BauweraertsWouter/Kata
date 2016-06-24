package com.wouter.kata.bowlinggame;

/**
 * Code Kata: Bowling Game
 *
 */
public class Bowling
{

    private int score = 0;
    private int[] allRolls = new int[23];
    private int currentRoll = 0;

    public int getScore() {
        int roll = 0;
        for (int i = 0; i < 10; i++) {
            if (allRolls[roll] == 10) {
                score += 10 + StrikeBonus(roll);
                roll++;
            }else if (isSpare(roll)){
                score += 10 + allRolls[roll+2];
                roll+=2;
            }else {
                score += allRolls[roll] + allRolls[++roll];
                roll++;
            }
        }
        return score;
    }

    private boolean isSpare(int roll) {
        return allRolls[roll] + allRolls[roll+1] == 10;
    }

    private int StrikeBonus(int roll) {
        return allRolls[roll + 1] + allRolls[roll + 2];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    public void roll(int pins) {
        allRolls[currentRoll++] = pins;
    }
}
