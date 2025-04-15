package org.example.leetcode_any;


import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,4,0,7,2,0,0,3,10};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

    }


    public static void moveZeroes(int[] nums) {
        int NullPoint = 0;
        for (int cur = 0; cur < nums.length; cur++) {
           if (nums[cur] != 0) {
               int temp = nums[NullPoint];
               nums[NullPoint] = nums[cur];
               nums[cur] = temp;
               NullPoint++;
           }
        }
    }
}
