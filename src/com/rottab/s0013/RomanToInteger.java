package com.rottab.s0013;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class RomanToInteger {
    public int romanToInt1(String s) {
        Map<Character, Integer> map = Map
                .of('I', 1,
                        'V', 5,
                        'X', 10,
                        'L', 50,
                        'C', 100,
                        'D', 500,
                        'M', 1000);
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (map.get(stack.peek()) > map.get(c)) {
                    while (!stack.isEmpty()) sum += map.get(stack.pop());
                } else if (map.get(stack.peek()) < map.get(c)) {
                    while (!stack.isEmpty()) sum -= map.get(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) sum += map.get(stack.pop());
        return sum;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = Map
                .of('I', 1,
                        'V', 5,
                        'X', 10,
                        'L', 50,
                        'C', 100,
                        'D', 500,
                        'M', 1000);
        Character pc = s.charAt(0);
        if (s.length() == 1) return map.get(pc);
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer value = map.get(pc);
            if (map.get(pc) >= map.get(c)) sum += value;
            else sum -= value;
            pc = c;
        }
        sum += map.get(pc);
        return sum;
    }

    public int romanToInt3(String s) {
        Map<Character, Integer> map = Map
                .of('I', 1,
                        'V', 5,
                        'X', 10,
                        'L', 50,
                        'C', 100,
                        'D', 500,
                        'M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            }
            else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    @Test
    public void test1() {
        assert romanToInt1("I") == 1;
        assert romanToInt1("MC") == 1100;
        assert romanToInt1("MCM") == 1900;
        assert romanToInt1("III") == 3;
        assert romanToInt1("IV") == 4;
        assert romanToInt1("VI") == 6;
        assert romanToInt1("LVIII") == 58;
        assert romanToInt1("MCMXCIV") == 1994;
    }

    @Test
    public void test2() {
        assert romanToInt2("I") == 1;
        assert romanToInt2("MC") == 1100;
        assert romanToInt2("MCM") == 1900;
        assert romanToInt2("III") == 3;
        assert romanToInt2("IV") == 4;
        assert romanToInt2("VI") == 6;
        assert romanToInt2("LVIII") == 58;
        assert romanToInt2("MCMXCIV") == 1994;
    }

    @Test
    public void test3() {
        assertEquals(1, romanToInt3("I"));
        assertEquals(1100, romanToInt3("MC"));
        assertEquals(1900, romanToInt3("MCM"));
        assertEquals(3, romanToInt3("III"));
        assertEquals(4, romanToInt3("IV"));
        assertEquals(6, romanToInt3("VI"));
        assertEquals(58, romanToInt3("LVIII"));
        assertEquals(1994, romanToInt3("MCMXCIV"));
    }
}
