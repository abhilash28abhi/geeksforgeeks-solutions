package com.geeksforgeeks.backtracking;

/*
    Backtracking is basically an optimization technique over recursion where in we don't
    check all the paths we simply back track and move ahead.
 */
public class NQueenProblem {

    final static int NUMBER_OF_QUEENS = 4;

    public static void main(String[] args) {
        int board[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 } };

        System.out.println("This problem is having a solution ? " + solveNQueen(board, 0));

        for (int i = 0; i < NUMBER_OF_QUEENS; i++) {
            for (int j = 0; j < NUMBER_OF_QUEENS; j++)
                System.out.print(" " + board[i][j]
                        + " ");
            System.out.println();
        }
    }

    private static boolean solveNQueen(int[][] board, int col) {
        if (col == NUMBER_OF_QUEENS) {
            return true;
        }

        for (int i = 0; i < NUMBER_OF_QUEENS; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueen(board, col + 1)) {
                    return true;
                }
                //backtracking happens here
                board[i][col] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < NUMBER_OF_QUEENS; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}
