package org.example.string;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1,2,3,4,6,7,8,10,11,13}));
    }

    //{1,2,3,4,6,7,8,10,11,13}

    public static List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();

        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if(i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    results.add(String.valueOf(start));
                } else {
                    results.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return results;
    }
}
