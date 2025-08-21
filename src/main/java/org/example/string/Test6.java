package org.example.string;

public class Test6 {
    // two points --> car a rac -> true

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        System.out.println(Test6.isValid(s));

    }
    public static boolean isValid(String s) {
        for (int l = 0, r = s.length() - 1; l <= r; l++, r--) {
            if ((l < r) && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            if (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }
       return true;
    }
}
