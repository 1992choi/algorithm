package inflearn;

import java.util.Scanner;

public class Ex01_11_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
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