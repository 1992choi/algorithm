package inflearn;

import java.util.Scanner;

public class Ex007 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String reversestr = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(reversestr)) {
            return "YES";
        } else {
            return "NO";
        }

    }

}