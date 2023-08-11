package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_12_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String str = in.nextLine();

        System.out.println(solution(num, str));
    }

    public static String solution(int num, String str) {
        String answer = "";

        for (int i = 0; i < num; i++) {
            String tmp = str.substring(i * 7, i * 7 + 6 + 1).replaceAll("#", "1").replaceAll("\\*", "0");
            answer += (char)Integer.parseInt(tmp, 2);
        }

        return answer;
    }

}
