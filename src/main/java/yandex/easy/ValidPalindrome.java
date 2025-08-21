package yandex.easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isAPalindrome("Was it a car or a cat I saw?"));
    }
//O(n) Time complexity
    public static boolean isAPalindrome(String s) {


        //идём с двух сторон l - left, r - right. + индекс последнего элемента - длинна - 1
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            //пропускаем знаки, если не символ алфавита или числа(проходимся по каждому индексу символа l)
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            //игнорирование учета регистра
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }
            return true;

    }
}
