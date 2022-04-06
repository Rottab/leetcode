package com.rottab.s0020;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) stack.push(c);
            else if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.pop() != '(') return false;
            } else if (c == ']') {
                if (stack.pop() != '[') return false;
            } else if (c == '}') {
                if (stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertThat(isValid(")")).isFalse();
        assertThat(isValid("(")).isFalse();
        assertThat(isValid("()")).isTrue();
        assertThat(isValid("(]")).isFalse();
        assertThat(isValid("(){}[]")).isTrue();
        assertThat(isValid("({[]})")).isTrue();
        assertThat(isValid("((")).isFalse();
    }
}
