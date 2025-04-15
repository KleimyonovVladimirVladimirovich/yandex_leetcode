package org.example;

import java.util.Arrays;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twosumtest(new int[]{1, 3, 5, 7}, 12)));
    }

    public static int[] twosumtest(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(target - nums[i])) {
                return new int[]{maps.get(target - nums[i]), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }
}
