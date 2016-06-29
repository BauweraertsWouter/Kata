package com.wouter.kata.gameOfLife;

/**
 * Created by Wouter on 29/06/2016.
 * Java implementation for the Game of Life by Conway
 */
public class GameOfLife {
    public int getCellStatus(int i) {
        return i;
    }

    public int countNeighbours(int state, int[][] matrix, int row, int column) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            if (row + i >= 0 && row + i <matrix.length){
                for (int j = -1; j <2; j++) {
                    if (column + j >= 0 && column + j <  matrix[row + i].length){
                        if (matrix[row + i][column + j] == state)
                            if(!((row == row+i) && (column == column+j)))count++;
                    }
                }
            }
        }
        return count;
    }

    public int kill(int[][] matrix, int row, int column) throws IllegalArgumentException {
        if (matrix[row][column] == 0) throw new IllegalArgumentException("Tis is a dead cell");
        else if (this.countNeighbours(1, matrix, row, column) < 2) return 0;
        else if (countNeighbours(1, matrix, row, column)>3) return 0;
        else return 1;
    }

    public int[][] nextGen(int[][] matrix) {
        int[][] nextGen = new int[matrix.length][matrix[0].length];
        //implementation
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) nextGen[i][j]=cellAlive(matrix, i, j);
                else nextGen[i][j] = kill(matrix, i, j);
            }
        }
        return nextGen;
    }

    public int cellAlive(int[][] matrix, int row, int column) throws IllegalArgumentException{
        if (matrix[row][column]==1) throw new IllegalArgumentException("This cell is already alive");
        else if (this.range(this.countNeighbours(1, matrix, row, column))) return 1;
        else return 0;
    }

    private boolean range(int i) {
        if (i < 2 || i > 3) return false;
        else return true;
    }

}
