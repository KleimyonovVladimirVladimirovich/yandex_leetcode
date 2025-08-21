package yandex.easy;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 2, 0, 0, 2, 0}));
    }
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int trap(int[] height) {
        if (height.length == 0 || height == null) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        while (leftMax < rightMax) {
            if (leftMax == 0) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;

    }
}
