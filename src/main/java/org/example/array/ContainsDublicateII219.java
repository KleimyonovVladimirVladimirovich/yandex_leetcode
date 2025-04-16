package org.example.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDublicateII219 {

    public boolean containsDublicate(int[] nums, int k) {
       Set<Integer> setMap = new HashSet<>();
       for (Integer num : nums) {



           setMap.add(num);
       }
    }
}
