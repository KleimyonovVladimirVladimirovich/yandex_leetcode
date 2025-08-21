package org.example.coderun;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(concArray(new int[]{1, 2, 3})));

    }
    public static int[] concArray(int[] nums) {

        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i + n] = nums[i];
        }
        return arr;
    }
}
