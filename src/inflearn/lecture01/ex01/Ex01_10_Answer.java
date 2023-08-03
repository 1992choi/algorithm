package inflearn.lecture01.ex01;

import java.util.Arrays;
import java.util.Scanner;

public class Ex01_10_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputValue = in.nextLine();
        String str = inputValue.split(" ")[0];
        char targetChar = inputValue.split(" ")[1].charAt(0);

        System.out.println(solution(str, targetChar));
    }

    public static String solution(String str, char targetChar) {
        char[] chars = str.toCharArray();
        int[] answer = new int[str.length()];

        int p = 100;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == targetChar) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        p = 100;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == targetChar) {
                p = 0;
            } else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }

        return Arrays.toString(answer);
    }

}