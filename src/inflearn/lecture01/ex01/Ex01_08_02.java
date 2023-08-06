package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_08_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution (String str) {
        str = str.toLowerCase();

        int lp = 0;
        int rp = str.length() - 1;

        while (lp < rp) {
            if (Character.isAlphabetic(str.charAt(lp)) && Character.isAlphabetic(str.charAt(rp))) {
                if (str.charAt(lp) != str.charAt(rp)) {
                    return "NO";
                }
                lp++;
                rp--;
            } else if (!Character.isAlphabetic(str.charAt(lp))) {
                lp++;
            } else if (!Character.isAlphabetic(str.charAt(rp))) {
                rp--;
            } else {
                lp++;
                rp--;
            }
        }

        return "YES";
    }

}
