package org.example.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{5, 2, 9, 13}, 22)));
    }
    /*
        -I view: Brute Force.
        -О(1) constant space complexity
        -O(n^2) memory
    */
/*    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{nums[0]};
    } */


      /*
        -II view: Hashmap.
        -О(n) const time complexity
        -O(n) memory space complexity (bestie)
    */
      public static int[] twoSum(int[] nums, int target) {
          HashMap<Integer, Integer> map = new HashMap<>(); //<Key, Value>
          for (int i = 0; i < nums.length; i++) {
              if (map.containsKey(target - nums[i]) && (i != map.get(target - nums[i]))) {
                  return new int[]{map.get(target - nums[i]), i};
              }
              map.put(nums[i], i);
          }

       return null;
      }
}
