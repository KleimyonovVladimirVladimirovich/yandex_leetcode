package org.example.array;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram125 {
    public static void main(String[] args) {
        //ток-кот, куб-бук, апорт-тропа, торг-грот true
        System.out.println(isAnagram("carrace", "racecar"));
    }

//    -I view: Sorting.
//    -О(nlogn+mlogm) -> O(nlogn) constant time complexity
//    -O(n+m)(in average),O(1)(bestie) memory spaced complexity
/*    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSort =  s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    } */

    //    -II view: HashMap.
    //    -О(n) constant time complexity
    //    -O(1) memory spaced complexity
    public static boolean isAnagram(String s, String t) {
      if(s.length() != t.length()) {
          return false;
      }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }

}
