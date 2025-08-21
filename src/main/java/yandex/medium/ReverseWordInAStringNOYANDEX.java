package yandex.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//нет в яндексе
public class ReverseWordInAStringNOYANDEX {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords1("the sky is blue"));
    }
    public static String reverseWords(String s) {
        String[] words = s.split("\\s+");
        List<String> list = Arrays.asList(words);
        Collections.reverse(list);
        return String.join(" ", list);
    }
    public static String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0 ; i--) {
            sb.append(words[i]);

            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
