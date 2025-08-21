package org.example.array;

public class ValidPAlindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Race a ecar"));
    }

    public static boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

        }
        return true;
    }
}
