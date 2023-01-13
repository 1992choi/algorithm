package inflearn;

import java.util.Scanner;

public class Ex01_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
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

}