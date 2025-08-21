package org.example.string;

import java.util.*;

public class Repeat0308 {
    public static void main(String[] args) {
        System.out.println(isParentheses("("));
        System.out.println(summaryRanges(new int[]{1, 2, 3, 5, 6, 7, 9}));
    }
    public static boolean isReflection(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<List<Integer>> result = new HashSet<>();
        for(int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX,point[0]);
            result.add(List.of(point[0], point[1]));
        }

        int sum = minX + maxX;
        for (int[] point : points) {
            if(!result.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if (map.get(c) != top) {
                    return true;
                }
            }
        }
        return stack.isEmpty();
    }
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        List<String> result = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if(start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return result;
    }
}
