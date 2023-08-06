package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_09_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
    }

    public static int solution (String str) {
        String answer = "";

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += String.valueOf(c);
            }
        }

        return Integer.parseInt(answer);
    }

}
