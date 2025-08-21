package org.example.tree;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(concatArray(new int[]{1, 2, 3})));
    }
    public static int[] concatArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = arr[i + n] = nums[i];
        }
        return arr;
    }
}
