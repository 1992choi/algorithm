package inflearn;

import java.util.Scanner;

public class Ex011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        str += ";";
        String answer = "";
        char prevChar = str.charAt(0);

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == prevChar) {
                count++;
            } else {
                answer += prevChar;
                if (count != 1) {
                    answer += count;
                }
                prevChar = str.charAt(i);
                count = 1;
            }

        }

        return answer;
    }

    public static String solution2(String str) {
        str += ";";
        String answer = "";

        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                answer += str.charAt(i);
                if (count != 1) {
                    answer += count;
                }
                count = 1;
            }

        }

        return answer;
    }

}