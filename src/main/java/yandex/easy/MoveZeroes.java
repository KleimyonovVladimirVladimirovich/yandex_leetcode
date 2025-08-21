package yandex.easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] result = new int[]{1,0,0,3,4,7,0,0,6,0,7,8,2,0,10};
        moveZeroes(result);
//        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
    }

    public static void moveZeroes(int[] nums) {
        int NullPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[NullPoint];
                nums[NullPoint] = nums[i];
                nums[i] = temp;
                NullPoint++;
            }
        }
    }
}
