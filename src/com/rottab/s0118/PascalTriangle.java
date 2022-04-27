package com.rottab.s0118;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new LinkedList();
        pascalTriangle.add(List.of(1));
        for (int row = 1; row < numRows; row++) {
            List<Integer> nextRow = new LinkedList<>();
            List<Integer> previousRow = pascalTriangle.get(row - 1);
            for (int i = 0; i <= row; i++) {
                if (i == 0 || i == row) nextRow.add(1);
                else nextRow.add(previousRow.get(i - 1) + previousRow.get(i));

            }
            pascalTriangle.add(nextRow);
        }
        return pascalTriangle;
    }

    @Test
    public void test() {
        assertThat(generate(1)).isEqualTo(List.of(List.of(1)));
        assertThat(generate(2)).isEqualTo(List.of(List.of(1), List.of(1, 1)));
        assertThat(generate(3)).isEqualTo(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1)));
        assertThat(generate(4)).isEqualTo(List.of(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1)));
    }
}
