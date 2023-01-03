package inflearn;

import java.util.Scanner;

public class Ex003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
    }

    public static String solution(String str) {
        String answer = "";
        String[] strArr = str.split(" ");
        int max = 0;
        for (String s : strArr) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }

        return answer;
    }

    public static String solution2(String str) {
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
