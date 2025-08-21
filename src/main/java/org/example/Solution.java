package org.example;

import javax.print.attribute.standard.MediaSize;
import java.nio.charset.StandardCharsets;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 6, 8, 9, 11}));
//        System.out.println(isAnagram("racecare", "carrace"));
//        int[] res = new int[]{1,0,0,2,3,0,5,0,6,0,0,8,9,0};
//        moveZeroes(res);
//        System.out.println(Arrays.toString(res));
    }
//    public static int[] sum(int[] nums, int target) {
//        Map<Integer, Integer> integerMap = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (integerMap.containsKey(target - nums[i]) && (i != integerMap.get(target - nums[i]))) {
//                return new int[]{integerMap.get(target - nums[i]), i};
//            }
//            integerMap.put(nums[i], i);
//        }
//        return null;
//    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> sStr = new HashMap<>();
//        Map<Character, Integer> tStr = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            sStr.put(s.charAt(i), sStr.getOrDefault(s.charAt(i), 0) + 1);
//            tStr.put(t.charAt(i), tStr.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        return sStr.equals(tStr);
//    }

//    public static void moveZeroes(int[] nums) {
//        int NullPoint = 0;
//        for (int current = 0; current < nums.length; current++) {
//            if (nums[current] != 0) {
//                int temp = nums[NullPoint];
//                nums[NullPoint] = nums[current];
//                nums[current] = temp;
//                NullPoint++;
//            }
//
//        }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    list.add(String.valueOf(start));
                } else {
                    list.add(start + " - > " + nums[i - 1]);
                    if (i < nums.length) {
                        start = nums[i];
                    }
                }
            }
        }
        return list;
    }
}