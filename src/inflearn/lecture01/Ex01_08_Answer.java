package inflearn.lecture01;

import java.util.Scanner;

public class Ex01_08_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String reverseStr = new StringBuilder(str).reverse().toString();

        if (str.equals(reverseStr)) {
            return "YES";
        } else {
            return "NO";
        }
    }

}