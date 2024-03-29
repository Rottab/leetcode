package com.rottab.s0036;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidSudoku {
    public boolean isValidate(char[][] board, int row, int column) {
        char value = board[row][column];
        int i1 = row - row % 3;
        int e1 = i1 + 3;
        int i2 = column - column % 3;
        int e2 = i2 + 3;
        for (int i = i1; i < e1; i++) {
            for (int j = i2; j < e2; j++) if ((i != row && j != column) && board[i][j] == value) return false;
        }
        for (int i = 0; i < board.length; i++) {
            if ((i != column && board[row][i] == value) || (i != row && board[i][column] == value))
                return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !isValidate(board, i, j)) return false;
            }
        }
        return true;
    }


    @Test
    public void testValidate() {
        char[][] board1 = new char[][]{
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
        assertThat(isValidSudoku(board1)).isTrue();
        char[][] board2 = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertThat(isValidSudoku(board2)).isFalse();
    }
}
