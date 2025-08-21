package yandex.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{5, 7,12, 4, 9}, 12)));
    }
    // KEY -> VALUE
    // VALUE -> KEY
     public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

         for (int i = 0; i < nums.length; i++) {
             if (map.containsKey(target - nums[i]) && (i != map.get(target - nums[i]))){
                 return new int[]{map.get(target - nums[i]), i};
             }
             map.put(nums[i], i);
         }
         return null;
     }
}
