package inflearn;

import java.util.Scanner;

public class Ex009 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        System.out.println(solution(str));
        System.out.println(solution2(str));
        System.out.println(solution3(str));
    }

    public static int solution(String str) {
        return Integer.parseInt(str.replaceAll("[^0-9]",""));
    }

    public static int solution2(String str) {
        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }

        return answer;
    }

    public static int solution3(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }

        return Integer.parseInt(answer);
    }

}