package org.example.string;

import java.util.*;

public class Repeat0208 {
    public static void main(String[] args) {
        System.out.println(isReflection(new int[][]{
                {0,0},
                {-0,-0},
                {10, 3},
                {-10, 3},
                {-2, -4},
                {2, -4},
                {-2, 4}

        }));

        System.out.println(isContains(new int[]{1, 2, 3, 1}, 3));
    }
    public static boolean isReflection(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<List<Integer>> result = new HashSet<>();
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX,point[0]);
            result.add(List.of(point[0], point[1]));
        }
        int sum = minX + maxX;
        for (int[] point : points) {
            if (!result.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isContains(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return map.isEmpty();
    }

    public static boolean isContains1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return map.isEmpty();
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        }
        return sMap.equals(tMap);
    }


    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> list  = new ArrayList<>(List.of(words));
        Collections.reverse(list);
        return String.join(" ", list);

    }
}
