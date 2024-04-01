package com.rottab.s0012;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class Pair {
    int value;
    String symbol;

    public Pair(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }
}

public class IntegerToRoman {
    List<Pair> list = List
            .of(
                    new Pair(1, "I"),
                    new Pair(4, "IV"),
                    new Pair(5, "V"),
                    new Pair(9, "IX"),
                    new Pair(10, "X"),
                    new Pair(40, "XL"),
                    new Pair(50, "L"),
                    new Pair(90, "XC"),
                    new Pair(100, "C"),
                    new Pair(400, "CD"),
                    new Pair(500, "D"),
                    new Pair(900, "CM"),
                    new Pair(1000, "M")
            );


    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            int value = list.get(i).value;
            if (num / value > 0){
                int count = num / value;
                stringBuilder.append(String.valueOf(list.get(i).symbol).repeat(count));
                num = num % value;
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        assertEquals("I", intToRoman(1));
        assertEquals("III", intToRoman(3));
        assertEquals("XI", intToRoman(11));
        assertEquals("LVIII", intToRoman(58));
    }
}
