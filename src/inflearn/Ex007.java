package inflearn;

import java.util.Scanner;

public class Ex007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(reverseStr)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String solution2(String str) {
        str = str.toUpperCase();
        int len = str.length();
        for (int i = 0 ; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return "NO";
            }
        }

        return "YES";
    }

}