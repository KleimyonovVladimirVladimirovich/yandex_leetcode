package org.example.string;

import java.util.Arrays;

public class Test8 {
    //new int[]{1,0,0,3,0,4,5,6,0,0,7,10,0}
    public static void main(String[] args) {
        System.out.println(reverseWord("Let's talk about Java"));
    }

     public static StringBuilder reverseWord(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder sb = new StringBuilder(word).reverse();
            result.append(sb).append(" ");
        }
         result.deleteCharAt(result.length() - 1);
        return result;
     }
}
