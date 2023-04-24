package inflearn.lecture01;

import java.util.Scanner;

public class Ex01_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
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

}
