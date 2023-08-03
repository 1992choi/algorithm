package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
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

}