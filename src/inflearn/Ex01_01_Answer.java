package inflearn;

import java.util.Scanner;

public class Ex01_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char ch = in.nextLine().charAt(0);

        System.out.println(solution(str, ch));
    }

    public static int solution(String str, char ch) {
        int answer = 0;
        str = str.toUpperCase();
        ch = Character.toUpperCase(ch);
        for (char c : str.toCharArray()) {
            if (c == ch) {
                answer++;
            }
        }

        return answer;
    }

}
