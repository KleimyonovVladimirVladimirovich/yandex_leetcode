package yandex.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{1,2,1}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //OR
    public static int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
