package com.rottab.s0051;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Board {
    boolean[][] board;
    int c;


    public Board() {
    }

    public Board(boolean[][] board, int c) {
        this.board = board;
        this.c = c;
    }

    public void setBoard(boolean[][] board) {
        int length = board.length;
        this.board = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }
}


public class NQueens {
    public void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print((board[i][j] ? 1 : 0) + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < board.length; i++) {
            System.out.print("-\t");
        }
        System.out.println();
    }

    public Board constructBoard(int n) {
        return new Board(new boolean[n][n], -1);
    }

    public boolean isValid(boolean[][] board, int r, int c) {
        // ROW
        for (int i = 0; i < c; i++) if (board[r][i]) return false;
        // DIAGONAL
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) if (board[i][j]) return false;
        // DIAGONAL
        for (int i = r, j = c; i < board.length && j >= 0; i++, j--) if (board[i][j]) return false;
        return true;
    }

    public List<String> constructSolution(boolean[][] board) {
        List<String> solution = new LinkedList();
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board.length; j++) row.append(board[i][j] ? 'Q' : '.');
            solution.add(row.toString());
        }
        return solution;
    }

    public List<List<String>> solveNQueens(int n) {
        Board board = constructBoard(n);
        List<List<String>> solutions = new LinkedList<>();
        Stack<Board> stack = new Stack<>();
        stack.push(board);
        while (!stack.isEmpty()) {
            Board pop = stack.pop();
            if (pop.c == n - 1) {
                solutions.add(constructSolution(pop.board));
            } else {
                for (int i = 0; i < n; i++) {
                    if (isValid(pop.board, i, pop.c + 1)) {
                        Board newBoard = new Board();
                        newBoard.setBoard(pop.board);
                        newBoard.c = pop.c + 1;
                        newBoard.board[i][newBoard.c] = true;
                        stack.push(newBoard);
                    }
                }
            }
        }
        return solutions;
    }

    @Test
    public void test() {
        assertThat(solveNQueens(1)).isEqualTo(List.of(List.of("Q")));
        assertThat(solveNQueens(4)).isEqualTo(List.of(List.of(".Q..", "...Q", "Q...", "..Q."), List.of("..Q.", "Q...", "...Q", ".Q..")));
        assertThat(solveNQueens(2).size()).isEqualTo(0);
        assertThat(solveNQueens(5).size()).isEqualTo(10);
        assertThat(solveNQueens(6).size()).isEqualTo(4);
        assertThat(solveNQueens(7).size()).isEqualTo(40);
        assertThat(solveNQueens(8).size()).isEqualTo(92);
    }
}
