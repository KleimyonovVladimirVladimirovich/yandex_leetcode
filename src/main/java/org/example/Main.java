package org.example;

import java.util.*;

// {1,5,4,7,8,4,3,8,9,0,4,2,1,2,3,4,2}
//


public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedArray(new int[]{-5,-3,1,0,1,2,4,6})));

//     public static int[] frequencyElement(int[] nums, int k) {
//         Map<Integer, Integer> freqMap = new HashMap<>();
//         for (Integer num : nums) {
//             freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//         }
//
//         List<Integer>[] buckets = new List[nums.length + 1];
//         freqMap.forEach((num, freq) -> {
//             if (buckets[freq] == null) {
//                 buckets[freq] = new ArrayList<>();
//             }
//             buckets[freq].add(num);
//         });
//         List<Integer> res = new ArrayList<>();
//         for (int i = buckets.length - 1; i > 0 && res.size() < k ; i--) {
//             if (buckets[i] != null) {
//                 res.addAll(buckets[i]);
//             }
//         }
//         return res.stream().mapToInt(i -> i).toArray();
//     }

//    public static int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(target - nums[i]) && (i != map.get(target - nums[i]))) {
//                return new int[]{map.get(target - nums[i]), i};
//            }
//            map.put(nums[i],i);
//        }
//        return null;
//    }

    }
    public static int[] sortedArray(int[] nums) {
        int lP = 0, rP = nums.length - 1;
        int[] sortedArray = new int[nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            int left = Math.abs(nums[lP]);
            int right = Math.abs(nums[rP]);

            if (left > right) {
                sortedArray[i] = left * left;
                lP++;
            } else {
                sortedArray[i] = right * right;
                rP--;
            }
        }
        return sortedArray;
    }
}
