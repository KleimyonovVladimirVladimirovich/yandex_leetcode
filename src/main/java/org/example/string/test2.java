package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("исКать такСи"));
        System.out.println(isPalindrome("wAs it a caR or a caT I saw?"));
    }



    public static boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            if (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            if (l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
        }
        return true;
    }
}
