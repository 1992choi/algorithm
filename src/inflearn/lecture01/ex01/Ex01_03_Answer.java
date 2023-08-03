package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_03_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";
        int max = 0;
        int pos;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            if (tmp.length() > max) {
                max = tmp.length();
                answer = tmp;
            }

            str = str.substring(pos + 1);
        }

        if (str.length() > max) {
            answer = str;
        }

        return answer;
    }

}
