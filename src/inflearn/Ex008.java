package inflearn;

import java.util.Scanner;

public class Ex008 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]","");
        String reverseStr = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(reverseStr)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String solution2(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String reverseStr = new StringBuilder(str).reverse().toString();

        if (str.equals(reverseStr)) {
            return "YES";
        } else {
            return "NO";
        }
    }

}