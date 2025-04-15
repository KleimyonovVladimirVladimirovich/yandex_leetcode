package org.example.array;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4,5}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4,5,5}));
    }

    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
