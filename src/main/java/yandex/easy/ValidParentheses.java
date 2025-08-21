package yandex.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if (top != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
