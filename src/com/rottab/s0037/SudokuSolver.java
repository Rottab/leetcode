package com.rottab.s0037;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SudokuSolver {

    public void display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }

    public boolean isValid(char[][] board, int row, int column, char value) {
        int i1 = row - row % 3;
        int e1 = i1 + 3;
        int i2 = column - column % 3;
        int e2 = i2 + 3;
        for (int i = i1; i < e1; i++) {
            for (int j = i2; j < e2; j++) if (board[i][j] == value) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value || board[i][column] == value) return false;
        }
        return true;
    }


    public boolean solve(char[][] board, int p) {
        if (p == board.length * board.length) return true;
        int i = p / board.length;
        int j = p % board.length;
        if (board[i][j] != '.') return solve(board, p + 1);
        for (int v = 1; v <= board.length; v++) {
            char value = Character.forDigit(v, 10);
            if (isValid(board, i, j, value)) {
                board[i][j] = value;
                display(board);
                if (solve(board, p + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    @Test
    public void test1() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        char[][] solvedBoard = new char[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        assertThat(board).isEqualTo(solvedBoard);
    }

    @Test
    public void test2() {
        char[][] board = new char[][]{
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
        solveSudoku(board);
        char[][] solvedBoard = new char[][]{
                {'5', '1', '9', '7', '4', '8', '6', '3', '2'},
                {'7', '8', '3', '6', '5', '2', '4', '1', '9'},
                {'4', '2', '6', '1', '3', '9', '8', '7', '5'},
                {'3', '5', '7', '9', '8', '6', '2', '4', '1'},
                {'2', '6', '4', '3', '1', '7', '5', '9', '8'},
                {'1', '9', '8', '5', '2', '4', '3', '6', '7'},
                {'9', '7', '5', '8', '6', '3', '1', '2', '4'},
                {'8', '3', '2', '4', '9', '1', '7', '5', '6'},
                {'6', '4', '1', '2', '7', '5', '9', '8', '3'}
        };
        assertThat(board).isEqualTo(solvedBoard);
    }

    @Test
    public void testValidate() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertThat(isValid(board, 3, 3, '3')).isFalse();
        assertThat(isValid(board, 3, 3, '9')).isTrue();
        assertThat(isValid(board, 7, 7, '8')).isFalse();
        assertThat(isValid(board, 7, 7, '3')).isTrue();
        assertThat(isValid(board, 1, 1, '3')).isFalse();
        assertThat(isValid(board, 1, 1, '2')).isTrue();
    }
}
