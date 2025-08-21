package org.example.array;

import java.util.Arrays;

public class ConcatenationOfArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(concatenation(new int[]{1, 2, 3})));

    }
    public static int[] concatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }
}
