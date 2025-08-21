package yandex.easy;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 2, 3}));
    }
    public static int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }
}
